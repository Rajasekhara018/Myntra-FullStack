import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError, Observable } from 'rxjs';
import { ErrorMessageModule, ResObjectModule } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  cartCount: number = 0;
  wlCount: number = 0;
  isUserLoggedIn!: boolean;
  searchArray = new Array<any>();
  cartJson = new Array<any>();
  redirectUrl: any;
  // apiURL!: string;
  jwtToken: any
  constructor(public http: HttpClient, public snackBar: MatSnackBar) {
  }
  public doGetFile(apiPath: any): Observable<HttpResponse<Blob>> {
    let token = localStorage.getItem('token');
    if (!token) {
      token = sessionStorage.getItem('token');
    }
    const jwtToken = 'Bearer ' + token;
    let headers = new HttpHeaders({ 'Accept': '*/*', 'Authorization': jwtToken, 'Access-Control-Allow-Origin': '*' });
    // const apiPath = this.getBaseUrl() + messageId;
    return this.http.get(apiPath, {
      headers,
      observe: 'response',
      responseType: 'blob'
    });
  }
  public postFile(formData: FormData, apiURL: any) {
    let token = localStorage.getItem('token');
    if (!token) {
      token = sessionStorage.getItem('token');
    }
    const jwtToken = 'Bearer ' + token;
    const httpOptions = new HttpHeaders({ 'Accept': '*/*', 'Authorization': jwtToken, 'Access-Control-Allow-Origin': '*' });
    // const apiUrl = this.getBaseUrl() + messageId;
    return this.http.post<any>(apiURL, formData, { headers: httpOptions })
      .pipe(
        catchError(async (err) => this.handleError(err))
      );
  }
  getAlldata(apiURL: any,) {
    let token = localStorage.getItem('token');
    if (!token) {
      token = sessionStorage.getItem('token');
    }
    const jwtToken = 'Bearer ' + token;
    const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8', Authorization: jwtToken, 'Access-Control-Allow-Origin': '*' });
    return this.http.get(apiURL, { headers: httpOptions });
  }
  getdata(apiURL: any, id: string) {
    return this.http.get(`${apiURL}/${id}`);
  }

  postdata(apiURL: any, obj: any) {
    const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json;', 'Access-Control-Allow-Origin': '*' });
    return this.http.post(apiURL, obj,{ headers: httpOptions })
  }
  public dopostPagination(apiURL: any, reqObj: any, pageNo:any, pageSize:any) {
    const reqData = new ResObjectModule();
    reqData.messageID = apiURL;
    reqData.requestType = 'LIST';
    reqData.pageNo = pageNo;
    reqData.pageSize = pageSize;
    if (reqObj) {
      reqData.object = reqObj;
    }
    return this.postObservable(reqData);
  }
  public dopost(apiURL: any, reqObj: any) {
    const reqData = new ResObjectModule();
    reqData.messageID = apiURL;
    reqData.requestType = '';
    if (reqObj) {
      reqData.object = reqObj;
    }
    return this.postObservable(reqData);
  }

  update(apiURL: any, id: string, obj: any) {
    return this.http.put(`${apiURL}/${id}`, obj)
  }

  // delete(apiURL:any,id: string, obj: any) {
  //   return this.http.delete(`${apiURL}/${id}`, obj)
  // }
  delete(apiURL: any, id: string) {
    const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json;', 'Access-Control-Allow-Origin': '*' });
    return this.http.delete(`${apiURL}/${id}`,{ headers: httpOptions })
  }
  private postObservable(reqData: ResObjectModule) {
    let token = localStorage.getItem('token');
    if (!token) {
      token = sessionStorage.getItem('token');
    }
    const jwtToken = 'Bearer ' + token;
    const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8', Authorization: jwtToken, 'Access-Control-Allow-Origin': '*' });
    // let apiUrl = '';
    // apiUrl = this.getBaseUrl() + reqData.messageID;

    // if (reqData.object) {
    //   let obj = this.modifyReqResp(reqData.object);
    //   // let reqObj = this.removeEmpty(obj);
    //   reqData.object = obj;
    // }
    let apiUrl = reqData.messageID;
    return this.http.post<ResObjectModule>(apiUrl, JSON.stringify(reqData), { headers: httpOptions })
      .pipe(
        catchError(async (err) => this.handleError(err))
      );
  }
  public handleError(err: HttpErrorResponse) {
    let errorCode = '0000';
    let errorMessageDesc = 'Unknown Error Occured, Contact Administrator';
    if (err.error instanceof ErrorEvent) {
      console.error('An error occurred: ErrorEvent - Post Service');
      errorMessageDesc = err.error.message;
    } else {
      console.error('An error occurred: Backend Error - Post Service');
      errorCode = err.status.toString();
      if (err.error.message) {
        errorMessageDesc = err.error.message;
      }
      if (err.status === 401) {
        let isLogin = localStorage.getItem('token');
        if (!isLogin) {
          isLogin = sessionStorage.getItem('token');
        }
        if (isLogin) {
          // this.router.navigate(['401']);
        } else {
          localStorage.removeItem('token');
          localStorage.removeItem('currentUser');
          localStorage.removeItem('p');
          localStorage.clear();
          sessionStorage.removeItem('token');
          sessionStorage.clear();
          let errmsg = err?.error?.message;
          if (!errmsg) {
            errmsg = "May be you changed password or system detected unusual activity. Please Login again, Thank You!"
          }
          this.snackBar.open(errmsg, 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
        }
      }
    }
    const errorObject: ErrorMessageModule = {
      errorID: errorCode,
      errorMessage: errorMessageDesc,
      multipleMessage: []
    };
    // this.setNotif('error', errorObject);
    // return throwError(errorObject);
  }

  isloggedin() {
    if (localStorage.getItem('token')) {
      // logged in so return true
      return true;
    }
    return false;
  }
  getGoogleClientConfig(api: any) {
    const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    const apiUrl = api;
    return this.http.post<any>(apiUrl, { headers: httpOptions });
  }
}
