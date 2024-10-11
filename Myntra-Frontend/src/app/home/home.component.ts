import { Component, OnInit } from '@angular/core';
import { OwlOptions, SlidesOutputData } from 'ngx-owl-carousel-o';
import { PostService } from '../services/post.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  customOptions: OwlOptions = {
    loop: true,
    autoplay: true,
    autoplayTimeout: 3000,
    autoplaySpeed: 4000,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1,
        loop: true,
      },
      1200: {
        items: 2,
        loop: true,
      },
      1440: {
        items: 3,
        loop: true,
      },
      1900: {
        items: 1,
        loop: true,
      }
    },
    nav: true
  }
  activeSlides!: SlidesOutputData;

  slidesStore!: any[];
  constructor(public service: PostService) { }
  getPassedData(data: SlidesOutputData) {
    this.activeSlides = data;
    console.log(this.activeSlides);
  }
  ngOnInit(): void {
    // this.getMenData();
    this.getWomenData();
    // this.getKidData();
  }
  MenDataCarousel = new Array<any>();
  MenDataBiggestDeal = new Array<any>();
  MenDataBiggestDeal1 = new Array<any>();
  CarouselImages = new Array<any>();
  BigDealImages = new Array<any>();
  BigDealImages2 = new Array<any>();
  BigDetalTitle = new Array<any>();
  CategoryBag = new Array<any>();
  CategoryImage = new Array<any>();
  explore = new Array<any>();
  exploreImage = new Array<any>();
  MyntraLux = new Array<any>();
  MyntraLux1 = new Array<any>();
  myntraLuxeImage = new Array<any>();
  trendingIndianWear = new Array<any>();
  trendingIndianWear1 = new Array<any>();
  trendingIndianWear2 = new Array<any>();
  trendingIndianWearImage = new Array<any>();
  trendingSportsWear = new Array<any>();
  trendingSportsWearImage = new Array<any>();
  trendingFootWear = new Array<any>();
  trendingFootWearImage = new Array<any>();
  trendingAccessories = new Array<any>();
  trendingAccessoriesImage = new Array<any>();
  getMenData() {
    let apiURL = "http://localhost:6062/api/myntra/men";
    this.service.getAlldata(apiURL).subscribe((response: any) => {
      this.MenDataCarousel = response;
      this.MenDataCarousel.forEach((ele, i) => {
        let cardarray = ele.children[i].children;
        this.BigDetalTitle = ele.children[i].props;
        this.MenDataBiggestDeal1 =ele.children[2].children;
        this.MenDataBiggestDeal = ele.children[3].children; 
        this.CategoryBag = ele.children[5].children; 
        this.explore = ele.children[7].children;       
        this.MyntraLux = ele.children[9].children;
        this.trendingIndianWear =ele.children[11].children;
        this.trendingSportsWear = ele.children[13].children;
        this.trendingFootWear = ele.children[15].children;
        this.trendingAccessories = ele.children[17].children;
        cardarray.forEach((element: any) => {
          this.CarouselImages.push(element.props);
        })
      })
      this.MenDataBiggestDeal1.forEach((element:any,i)=>{
        
        this.BigDealImages.push(element.props);
      })
      this.MenDataBiggestDeal.forEach((element:any,i)=>{
        
        this.BigDealImages.push(element.props);
      })
      this.CategoryBag.forEach((element:any,i)=>{
        
        this.CategoryImage.push(element.props);
      })
      this.explore.forEach((element:any,i)=>{
        
        this.exploreImage.push(element.props);
      })
      this.MyntraLux.forEach((element:any,i)=>{
        
        this.myntraLuxeImage.push(element.props);
      })
      this.trendingIndianWear.forEach((element:any,i)=>{
        
        this.trendingIndianWearImage.push(element.props);
      })
      this.trendingSportsWear.forEach((element:any,i)=>{
        
        this.trendingSportsWearImage.push(element.props);
      })
      this.trendingFootWear.forEach((element:any,i)=>{
        
        this.trendingFootWearImage.push(element.props);
      })
      this.trendingAccessories.forEach((element:any,i)=>{
        
        this.trendingAccessoriesImage.push(element.props);
      })
    }, err => {
      console.log(err);
    })
  }
  getWomenData() {
    let apiURL = "http://localhost:6062/api/myntra/men";
    this.service.getAlldata(apiURL).subscribe((response: any) => {
      this.MenDataCarousel = response;
      this.MenDataCarousel.forEach((ele, i) => {
        let cardarray = ele.children[i].children;
        this.BigDetalTitle = ele.children[i].props;
        this.MenDataBiggestDeal1 =ele.children[2].children;
        this.MenDataBiggestDeal = ele.children[3].children; 
        this.CategoryBag = ele.children[5].children; 
        this.explore = ele.children[7].children;       
        this.MyntraLux = ele.children[9].children;
        this.trendingIndianWear =ele.children[11].children;
        this.trendingSportsWear = ele.children[13].children;
        this.trendingFootWear = ele.children[15].children;
        this.trendingAccessories = ele.children[17].children;
        cardarray.forEach((element: any) => {
          this.CarouselImages.push(element.props);
        })
      })
      this.MenDataBiggestDeal1.forEach((element:any,i)=>{
        
        this.BigDealImages.push(element.props);
      })
      this.MenDataBiggestDeal.forEach((element:any,i)=>{
        
        this.BigDealImages.push(element.props);
      })
      this.CategoryBag.forEach((element:any,i)=>{
        
        this.CategoryImage.push(element.props);
      })
      this.explore.forEach((element:any,i)=>{
        
        this.exploreImage.push(element.props);
      })
      this.MyntraLux.forEach((element:any,i)=>{
        
        this.myntraLuxeImage.push(element.props);
      })
      this.trendingIndianWear.forEach((element:any,i)=>{
        
        this.trendingIndianWearImage.push(element.props);
      })
      this.trendingSportsWear.forEach((element:any,i)=>{
        
        this.trendingSportsWearImage.push(element.props);
      })
      this.trendingFootWear.forEach((element:any,i)=>{
        
        this.trendingFootWearImage.push(element.props);
      })
      this.trendingAccessories.forEach((element:any,i)=>{
        
        this.trendingAccessoriesImage.push(element.props);
      })
    }, err => {
      console.log(err);
    })
  }
  getKidData() {
    let apiURL = "http://localhost:6062/api/myntra/men";
    this.service.getAlldata(apiURL).subscribe((response: any) => {
      this.MenDataCarousel = response;
      this.MenDataCarousel.forEach((ele, i) => {
        let cardarray = ele.children[i].children;
        this.BigDetalTitle = ele.children[i].props;
        this.MenDataBiggestDeal1 =ele.children[2].children;
        this.CategoryBag = ele.children[4].children;    
        this.explore = ele.children[6].children;   
        this.MyntraLux1 = ele.children[8].children;
        this.MyntraLux = ele.children[9].children;
        this.trendingIndianWear =ele.children[11].children;
        this.trendingIndianWear1 =ele.children[12].children;
        this.trendingIndianWear2 =ele.children[13].children;
        this.trendingSportsWear = ele.children[15].children;
        this.trendingFootWear = ele.children[17].children;
        this.trendingAccessories = ele.children[19].children;
        cardarray.forEach((element: any) => {
          this.CarouselImages.push(element.props);
        })
      })
      this.MenDataBiggestDeal1.forEach((element:any,i)=>{
        
        this.BigDealImages.push(element.props);
      })
      this.CategoryBag.forEach((element:any,i)=>{
        
        this.CategoryImage.push(element.props);
      })
      this.explore.forEach((element:any,i)=>{
        
        this.exploreImage.push(element.props);
      })
      this.MyntraLux1.forEach((element:any,i)=>{
        
        this.myntraLuxeImage.push(element.props);
      })
      this.MyntraLux.forEach((element:any,i)=>{
        
        this.myntraLuxeImage.push(element.props);
      })
      this.trendingIndianWear.forEach((element:any,i)=>{
        
        this.trendingIndianWearImage.push(element.props);
      })
      this.trendingIndianWear1.forEach((element:any,i)=>{
        
        this.trendingIndianWearImage.push(element.props);
      })
      this.trendingIndianWear2.forEach((element:any,i)=>{
        
        this.trendingIndianWearImage.push(element.props);
      })
      this.trendingSportsWear.forEach((element:any,i)=>{
        
        this.trendingSportsWearImage.push(element.props);
      })
      this.trendingFootWear.forEach((element:any,i)=>{
        
        this.trendingFootWearImage.push(element.props);
      })
      this.trendingAccessories.forEach((element:any,i)=>{
        
        this.trendingAccessoriesImage.push(element.props);
      })
    }, err => {
      console.log(err);
    })
  }
}
