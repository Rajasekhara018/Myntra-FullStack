export class Registration {
  firstName!: string;
  lastName!: string;
  userName!: string;
  phoneNo!: string;
  password!: string;
  email!: string;
  gender!: string;
  dob!: number;
}
export class Login {
  email!: string;
  password!: string;
}
export  class SignInObj {
  id!: string;
  encryptedPassword!: string;
  encryptedNewPassword!: string;
  encryptedConfPassword!: string;
  salt!: string;
  keyIndex!: string;
  otpValue!: string;
  success!: boolean;
  message!: string;
  otpReq!: boolean;
  otpLen!: number;
  otpIsAlphanumeric!: boolean;
  username!: string;
  // fullname: TName;
  token!: string;
  dashBoardID!: string;
  systemTimeZone!: Date;
  dateFormat!: string;
  timeFormat!: string;
  country!: string;
  defaultInstalledLanguages!: Array<string>;
  defaultPageSize!: number;
  // currencyArrVO: Array<CurrencyDetailVO>;
  priviledge!: string;
  lastSuccessLogin!: Date;
  lastfailedLogin!: Date;
  totalFailedAttempt!: number;
  currentFailedAttempt!: number;
  elapsedTimeInSec!: number;
  otpResendAttmepts!: number;
  passwordChangeRequired!: boolean;
  forgetPasswordEmail!: string;
  passLength!: number;
  isAlphabet!: boolean;
  isNumeric!: boolean;
  isAmpersand!: boolean;
  isAtTheRate!: boolean;
  isExclamatory!: boolean;
  isDollar!: boolean;
  isReset!: boolean;
  isSpecialChar!: boolean;
  isLowerCase!: boolean;
  isUpperCase!: boolean;
  merchantModelKey!: string;
  acqCurrentProcessingDate!: Date;
  theme!: string;
  allianceOrgModelKey!: string;
  allianceOrgKey!: string;
  defaultPhoneCode!: string;
  loginMobile!: string;
  loginEmail!: string;
  selectedMerchantNumber!: string;
  // merchantNameorNumber: Array<ABNameOrNumberVO>;
  googleIdToken!: string;
  // applicationNameorNumber: Array<ABNameOrNumberVO>;
  selectedApplication!: string;
  appID!: string;
  srBaseURL!: string;
  businessType!: Array<string>;
  googleClientId!: string;
  isSales!: boolean;
  helpBaseURL!: string;
  countryCode!: string;
  idxSwitch!: boolean;
  staSwitch!: boolean;
  // hopUserRules: Array<HopAllianceOrgRule>;
  helpMerchantURL!: string;
  srMerchantURL!: string;
  settlementBaseURL!: string;
  dashboardBaseURL!: string;
  onboardingBaseURL!: string;
  offerIFrameUrl!: string;
  switchIFrameUrl!: string;
  accountingIFrameUrl!: string;
  merchantIframeUrl!: string;
  defaultLanguage!: string;
}
export class Cart {
  id!: string;
  // email!: string;
  username!:string;
  shoppingCart!: Array<shoppingCart>;
  // shoppingCart!: shoppingCart;
}

export class ErrorMessageModule {
  errorID!: string;
  errorMessage!: string;
  multipleMessage!: Array<DetailErrorModule>;
}
export class DetailErrorModule {
  fieldName!: string;
  fieldValue!: string;
  message!: string;
}
export class shoppingCart {
  username!:string;
  id!: string;
  image: any;
  price!: number;
  qty!: number;
  name!: string;
  orderId!: string;
  brand!: string;
  size!: string;
}
export class ResObjectModule {
  pageNo!:number;
  pageSize!:number;
  messageID!: string;
  requestType!: string;
  userData!: string;
  success!: boolean;
  errors!: Array<string>;
  detailErrors!: Array<DetailErrorModule>;
  object!: Object;
}