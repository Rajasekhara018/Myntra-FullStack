import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { PostService } from './post.service';

@Injectable({
  providedIn: 'root'
})
export class CommonServiceService {

  constructor(private snackBar: MatSnackBar, private router: Router, public service: PostService,) { }
  getImage: any;
  value: any;
  // prefixFolder: string = "DISPTES";
  // modelKey: string = "Rajasekhar";
  prefixFolder!: string;
  modelKey!: string;
  uploadFile(event: any,name:any, subname:any) {
    // this.loading = true;
    if (!event.target.files[0]) {
      // this.loading = false;
      // this.nameInputRef.nativeElement.value = null;
      return;
    }
    const file = event.target.files[0];
    const documentData = new FormData();
    // let docName: string;
    // if (this.docmentName) {
    //   switch (file.type) {
    //     case 'image/jpeg':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.jpg'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.jpg'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.jpg';
    //       }
    //       break;
    //     case 'image/png':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.png'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.png'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.png'
    //       }
    //       break;
    //     case 'image/tiff':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.tiff'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.tiff'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.tiff'
    //       }
    //       break;
    //     case 'image/svg+xml':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.svg'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.svg'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.svg';
    //       }
    //       break;
    //     case 'application/pdf':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.pdf'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.pdf'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.pdf';
    //       }
    //       break;
    //     case 'application/vnd.openxmlformats-officedocument.wordprocessingml.document':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.docx'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.docx'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.docx';
    //       }
    //       break;
    //     case 'application/vnd.ms-excel':
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.csv'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.csv'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.csv';
    //       }
    //       break;
    //     default:
    //       if (this.rrn) {
    //         if (!this.value) {
    //           this.docName = this.rrn + '_' + 1 + '.txt'
    //         }
    //         this.value?.forEach((elment, i) => {
    //           this.docName = this.rrn + '_' + (i + 2) + '.txt'
    //         });
    //       } else {
    //         this.docName = this.docmentName + '.txt';
    //       }
    //       break;
    //   }
    // } else {
    // switch (file.type) {
    //   case 'image/jpeg':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.jpg'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.jpg'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    //   case 'image/png':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.png'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.png'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    //   case 'image/tiff':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.tiff'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.tiff'
    //       });
    //     } else {
    //       this.docName = this.docmentName + '.tiff'
    //     }
    //     break;
    //   case 'image/svg+xml':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.svg'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.svg'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    //   case 'application/pdf':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.pdf'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.pdf'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    //   case 'application/vnd.openxmlformats-officedocument.wordprocessingml.document':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.docx'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.docx'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    //   case 'application/vnd.ms-excel':
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.csv'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.csv'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    //   default:
    //     if (this.rrn) {
    //       if (!this.value) {
    //         this.docName = this.rrn + '_' + 1 + '.txt'
    //       }
    //       this.value?.forEach((elment, i) => {
    //         this.docName = this.rrn + '_' + (i + 2) + '.txt'
    //       });
    //     } else {
    //       this.docName = file.name;
    //     }
    //     break;
    // }
    // }
    // if (this.rrn) {
    //   if (file.type == 'image/jpeg' ||file.type == 'application/pdf' || file.type == 'image/tiff' || file.type == 'application/vnd.ms-excel' || file.type == '') {
    //   } else {
    //     this.snackbar.open("Please Upload PDF,TIFF,JPEG, XLS & PGP files", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
    //     this.loading = false;
    //     this.nameInputRef.nativeElement.value = null;
    //     return
    //   }
    // } else {
    if (file.type == 'image/jpeg' || file.type == 'image/png' || file.type == 'application/pdf' || file.type == 'text/csv'
      || file.type == 'application/vnd.openxmlformats-officedocument.wordprocessingml.document' || file.type == 'image/tiff'
      || file.type == 'application/vnd.ms-excel' || file.type == 'text/plain' || file.type == 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet') {
    } else {
      this.snackBar.open("Please Upload JPEG,PNG,PDF,TXT,DOC & CSV files", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
      // this.loading = false;
      // this.nameInputRef.nativeElement.value = null;
      return
    }
    // }
    if (file.size < 500) {
      this.snackBar.open("Min size 500 Bytes", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
      // this.loading = false;
      // this.nameInputRef.nativeElement.value = null;
      return;
    }
    // if (this.rrn) {
    //   if (file.size > 2000001) {
    //     this.snackbar.open("Max size 2MB", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
    //     this.loading = false;
    //     this.nameInputRef.nativeElement.value = null;
    //     return;
    //   }
    // } else {
    if (file.size > 5000001) {
      this.snackBar.open("Max size 5MB", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
      // this.loading = false;
      // this.nameInputRef.nativeElement.value = null;
      return;
    }
    // }
    // const regExp = /^[a-zA-Z0-9_]{1,200}\.[a-zA-Z0-9]{1,10}/;
    // if (!regExp.test(this.docName)) {
    // this.snackbar.open("File name must only contain alphanumeric characters and no spaces", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
    // this.loading = false;
    // this.nameInputRef.nativeElement.value = null;
    // return
    // }
    // if (this.value) {
    //   this.loading = false;
    //   if (this.value.find(obj => obj.name === this.docName)) {
    //     this.snackbar.open("Document already uploaded", 'Dismiss', { duration: 3000, panelClass: "snackbar-btn" });
    //     this.nameInputRef.nativeElement.value = null;
    //     return;
    //   }
    // }
    documentData.append('prefixFolder', name);
    documentData.append('filename', file.name);
    documentData.append('title', 'Image');
    documentData.append('file', file);
    documentData.append('modelKey', subname);
    let uploadUrl = "http://localhost:6062/flipkart/file/upload";
    this.service.postFile(documentData, uploadUrl)
      .subscribe((response) => {
        if (response.object) {
          // this.loading = false;
          if (!this.value) {
            this.value = new Array<any>();
          }
          this.value.push(response.object);
          // this.onChange(this.value);
          this.getImagefile(response.object);
          // this.docmentName = '';
        }
      }, response => {
        // this.loading = false;
      },
        () => {
          // this.nameInputRef.nativeElement.value = null;
        });
  }
  getImagefile(file: any) {
    if (!file) {
      return;
    }
    if (!file.location) {
      return;
    }
    if (!file.fileType) {
      return;
    }
    let downloadUrl = "http://localhost:6062/flipkart/file/download";
    const url = downloadUrl + '/' + file.prefixFolder + '/' + file.modelKey + '/' + file.name;
    this.service.doGetFile(url)
      .subscribe(response => {
        this.openFilePreview(response.body, file);
      });
  }
  openFilePreview(data: any, file: any) {
    const blob = new Blob([data], { type: file?.fileType });
    let reader = new FileReader();
    reader.addEventListener('load', () => {
      // this.getImage = reader.result;
      let flag = false;
      switch (file?.fileType) {
        case 'image/png':
          flag = this.pngDocValidCheck(reader?.result);
          break;
        case 'image/jpg':
        case 'image/jpeg':
          flag = this.jpgDocValidCheck(reader?.result);
          break;
        default:
          flag = this.jpgDocValidCheck(reader?.result);
          // flag = true;
          break;
      }
      if (flag) {
        this.getImage = reader.result;
        return data;
      } else {
        this.getImage = null;
        // this.value = new TUpload();
        // this.removeFile(file);
        this.snackBar.open('Please Upload Valid file', 'Dismiss', { duration: 3000, panelClass: 'snackbar-btn' });
        // this.onChange(this.value);
      }
    }, false);
    if (blob) {
      reader.readAsDataURL(blob);
    }
  }
  pngDocValidCheck(objData: any) {
    var imageData = Uint8Array.from(atob(objData?.replace('data:image/png;base64,', '')), c => c.charCodeAt(0))
    var sequence = [0, 0, 0, 0, 73, 69, 78, 68, 174, 66, 96, 130]; // in hex:
    //check last 12 elements of array so they contains needed values
    for (var i = 12; i > 0; i--) {
      if (imageData[imageData.length - i] !== sequence[12 - i]) {
        return false;
      }
    }
    return true;
  }
  jpgDocValidCheck(objData: any) {
    var imageData = Uint8Array.from(atob(objData?.replace('data:image/jpeg;base64,', '')), c => c.charCodeAt(0))
    return ((imageData[imageData.length - 1] === 217) && (imageData[imageData.length - 2] === 255))
  }
  downloadFile(file: any, idx: number) {
    if (file) {
      // this.loading = true;
      let downloadUrl = "http://localhost:6062/flipkart/file/download";

      const url: any = downloadUrl + '/' + file.prefixFolder + '/' + file.modelKey + '/' + file.name;
      this.service.doGetFile(url)
        .subscribe((reponse) => {
          debugger
          this.openFile(reponse.body, file.name, file.fileType);
        },
          response => {
            // this.loading = false;
          },
          () => { }
        );
    }
  }
  openFile(data: any, fileName: any, fileType: any) {
    // this.loading = false;
    let value: any;
    let blob = new Blob([data], { type: fileType });
    let reader = new FileReader();
    reader.addEventListener('load', () => {
      this.getImage = reader.result;
      if (this.getImage) {
        const link = document.createElement('a');
        link.download = fileName;
        link.href = this.getImage;
        link.click();
      }
    }, false);
    if (blob) {
      reader.readAsDataURL(blob);
    }
  }
  removeFile(file: any) {
    let index = this.value.indexOf(file);
    if (index >= 0) {
      this.value.splice(index, 1);
    }
    this.value = [...this.value];
    // this.cdr.detectChanges();
    // this.onChange(this.value);
    return this.value;
  }
  getText2ForKey(key: any) {
    let text2 = '';
    this.value?.forEach((element: any) => {
      if (element.name === key.name) {
        text2 = element.name!;
      }
    });
    return text2;
  }
}
