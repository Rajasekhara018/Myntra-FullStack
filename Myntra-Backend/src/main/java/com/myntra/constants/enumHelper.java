package com.myntra.constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum enumHelper {;
    private static final Logger logger = LoggerFactory.getLogger(enumHelper.class);
    public enum PrefixFolder {

        PRODUCT_INVENTORY("png, jpeg, jpg, svg"),
        MERCHANT_APPLICATION("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf, ppt, pptx, txt, csv"),
        APPLICATIONLEAD("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf, ppt, pptx, txt, csv"),
        MERCHANT_DOMAIN("png, jpeg, jpg, pdf, svg"), REPORTS("png, jpeg, jpg, svg"),
        SYSTEM_USER("png, jpeg, jpg, svg, csv"), ALLIANCE_USER("png, jpeg, jpg, svg"),
        EXTERNAL_USER("png, jpeg, jpg, svg"), output("png, jpeg, jpg, svg, pdf, csv"),
        SERVICE_REQUEST("png, jpeg, jpg, doc, xls, docx, xlsx, pdf, ppt, pptx, zip, 7z , txt, csv"),
        input("png, jpeg, jpg, svg, pdf"), OFFERS("png, jpeg, jpg, svg"), PAYMENT_PAGE_LOGO("png, jpeg, jpg, svg"),
        ACQUIRER("png, jpeg, jpg, svg"),
        ALLAINCE_ORG("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf , ppt, pptx , txt, csv"),
        TEMP_DIR("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf, ppt, pptx, txt, csv"),
        INCOMING_EMAIL("png, jpeg, jpg, svg"), MERCHANT_PROFILE("docx, xlsx"), FILE_UPLOAD_REQUEST("csv"),
        DATA_DOWNLOAD("csv"), PAY_INSTRUMENT_FACEID("png, jpeg, jpg"), SWITCH_CONTROL_LOGO("png, jpeg, jpg"),
        SERVICE_DIRECTORY("p12, txt"), PRODUCT_CATALOGUE("png, jpeg, jpg, svg"),
        DISPUTES("pdf,tiff,jpeg,xls,pgp");
        private String contentType;

        private PrefixFolder(String contentType) {
            this.contentType = contentType;
        }

        public boolean isAllowedContentType(String input, String filename) {
            String[] typ = this.contentType.split(",");
            String e = null;
            switch (input) {
                case "image/bmp":
                    e = "bmp";
                    break;
                case "text/csv":
                    e = "csv";
                    break;
                case "application/msword":
                    e = "doc";
                    break;
                case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                    e = "docx";
                    break;
                case "image/jpeg":
                    e = "jpeg";
                    break;
                case "application/json":
                    e = "json";
                    break;
                case "application/vnd.oasis.opendocument.text":
                    e = "odt";
                    break;
                case "image/png":
                    e = "png";
                    break;
                case "application/pdf":
                    e = "pdf";
                    break;
                case "application/vnd.ms-powerpoint":
                    e = "ppt";
                    break;
                case "application/vnd.openxmlformats-officedocument.presentationml.presentation":
                    e = "pptx";
                    break;
                case "image/svg+xml":
                    e = "svg";
                    break;
                case "text/plain":
                    e = "txt";
                    break;
                case "application/vnd.ms-excel":
                    e = "xls";
                    break;
                case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
                    e = "xlsx";
                    break;
                case "application/zip":
                    e = "zip";
                    break;
                case "application/x-7z-compressed":
                    e = "7z";
                    break;
                case "application/tiff":
                    e = "tiff";
                    break;
                case "image/pgp":
                    e = "pgp";
                    break;
                case "application/octet-stream":
                    e = "unknown";
                    if (filename != null) {
                        logger.info("print filename : ".concat(filename));
                        if (filename.contains(".")) {
                            e = filename.substring(filename.lastIndexOf(".") + 1);
                        }
                    }
                    break;
                case "application/x-pkcs12":
                    e = "p12";
                    break;
                default:
                    e = "unknown";
                    break;
            }

            for (String s : typ) {
                if (s.strip().toLowerCase().equals(e.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

    }
    public enum FileRetentionPolicyEnum {
        RETAIN_SHORT, RETAIN_NORMAL, RETAIN_LONG, RETAIN_EVER
    }
    public enum MessageEnum {
        SAMPLE_GET_V1, APP_LIST_ALL_V1, APP_CREATE_V1, APP_UPDATE_V1, APP_GET_BY_ID_V1, APP_DEL_BY_ID_V1,
        APP_ONETIME_V1, APP_DATAENTRY_ONE_V1, APP_DATAENTRY_TWO_V1, APP_DATAENTRY_THREE_V1, APP_ADD_TENDER_LINEITEM_V1,
        APP_UPDATE_TENDER_LINEITEM_V1, APP_GET_TENDER_SUMMARY_V1, APP_POST_TENDER_SUMMARY_V1, APP_MERCHANTAPP_CRUD,
        APP_DELETE_TENDER_LINEITEM_V1, APP_TENDER_STATUS_V1, APP_AGENT_CRUD, APP_GENCONFIG_CRUD, APP_ACQUIRER_CRUD,
        APP_BIN_CRUD, APP_PINCODE_CRUD, APP_HELPER_CRUD, APP_SYSTEMUSER_CRUD, APP_ROLE_CRUD, APP_PRIVILEDGE_CRUD,
        APP_MCC_CRUD, APP_TRANSACTIONALCONTROL_CRUD, APP_LEDGERACCOUNT_CRUD, APP_COMMUNICATION_CRUD, APP_TAX_CRUD,
        APP_FEE_CRUD, APP_REBATE_CRUD, APP_MERCHANTPROFILING_CRUD, APP_FRAUDRISK_CRUD, APP_MERCHANTCHAIN_CRUD,
        APP_SWITCH_CRUD, APP_PRODUCTINVENTORY_CRUD, APP_PRICING_CRUD, APP_EXCHANGERATES_CRUD,
        APP_COMMUNICATIONTEMPLATE_CRUD, APP_GLMASTER_CRUD, APP_CROSS_REFERENCE_CRUD, APP_MERCHANT_REJECT_CRUD,
        APP_SETTELMENT_CRUD, APP_APPL_DUPLICATE_CHECK_CRUD, APP_FRAUDDATA_CRUD, APP_BANK_TERMINATED_MERCHANT_CRUD,
        APP_CIBIL_MERCHANT_CRUD, APP_DSA_USER_CRUD, APP_AMEX_CRUD, APP_DINER_CRUD, APP_DISCOVER_CRUD, APP_UPI_CRUD,
        APP_RUPAY_CRUD, APP_MASTER_CRUD, APP_VISA_CRUD, APP_CHINA_CRUD, APP_NCCC_CRUD, APP_MERCHANTMASTER_CRUD,
        APP_MERCHANTDOMAIN_CRUD, APP_MERCHANTDEMOGRAPHICS_CRUD, APP_IDX_CREATE
    }
    public enum CRUDEnum {
        CREATE, UPDATE, QUERY, DELETE, LIST, SERVICE, NOTUSED, SAVE_DRAFT, SUBMIT, POSTING, UPD_APPROVE, UPD_REJECT,
        UPD_COMPARE

    }
}
//public enum TracingFlagEnum {
//    AuthBusinessLogic, AuthorizationService, ServiceDirectoryImpl, AuthorizationControllerValidate,
//    AuthController_paymentpares, AuthController_newForgotPassPrivate, CustomerLoginControllerRegister,
//    CustomerLoginControllerEnrol, WalletControllerEnrol, WalletControllerInq, SearchServiceSearch,
//    CommunicationBusService, PostingSequence, OnbApplicationNew
//}
//
//public enum MerchantBusinessTypeEnum {
//    LARGE, SMALL, BOTH
//}
//
//public enum FRMReasonCodeEnum {
//    FR_A_01("Inactive Merchant Transacting"),
//
//    FR_A_02("Transactions during non-operating hours"),
//
//    FR_A_03("Suspicious multiple transactions with same card/BIN"),
//
//    FR_A_04("High value ticket size"),
//
//    FR_A_05("Suspicious Non EMV transactions"),
//
//    FR_A_06("Suspicious high contactless transaction"),
//
//    FR_A_07("Enrollment Status"),
//
//    FR_A_08("ECI Status"),
//
//    FR_A_09("Refund Based On Payment Status"),
//
//    FR_A_10("Refund Based On Clearing Status"),
//
//    FR_A_11("Daily Refund Limit Status"),
//
//    FR_A_12("Monthly Refund Limit Status"),
//
//    FR_A_13("International Card Usage Based On Country Code"),
//
//    FR_A_14("DCC Control Status"),
//
//    FR_S_01("Delivery date"),
//
//    FR_S_02("Match the transaction"),
//
//    FR_S_03("Inactive merchant transacting"),
//
//    FR_S_04("Transactions during non-operating hours"),
//
//    FR_S_05("Suspicious multiple transactions with same card/BIN"),
//
//    FR_S_06("High value ticket size"),
//
//    FR_S_07("Suspicious Fallback transactions"),
//
//    FR_S_08("Suspicious Non EMV transactions"),
//
//    FR_S_09("Suspicious high contactless transaction"),
//
//    FR_S_10("Merchant refund"),
//
//    FR_S_11("Higher dispute"),
//
//    FR_S_12("Transaction processed from same card and different city"),
//
//    FR_S_13("Suspicious High Velocity transaction");
//
//    private String description;
//
//    private FRMReasonCodeEnum(String description) {
//        this.description = description;
//    }
//
//    public String getDescription() {
//        if (this.description == null) {
//            return "";
//        }
//        return this.description;
//    }
//}
//
//public enum AddDeleteClerkEnum {
//    ADD, DELETE, DF, C
//}
//
//public enum ClerkUserTypeEnum {
//    REGULAR, SUPERVISOR
//}
//
//public enum ReminderSendToEnum {
//    NON_ENROLLED, ENROLLED, BOTH, NONE
//}
//
//public enum ThemeEnum {
//    LIGHT, DARK
//}
//
//public enum CallbackBodyContentTypeEnum {
//    JSON, KEY_VALUE
//}
//
//public enum CallbackBodyObjectTypeEnum {
//    AUTH_RESPONSE
//}
//
//public enum MidTidGenerationTypeEnum {
//    NUM_OF_DIGIT, RANGE, NUM_OF_DIGIT_AND_RANGE
//}
//
//public enum JurisdictionEnum {
//    DOMESTIC, INTERREGIONAL, INTRAREGIONAL, ALL
//}
//
//public enum RegionEnum {
//    US, NON_US, CANADA, NON_CANADA, AP, NON_AP, LAC, NON_LAC, CEMEA, NON_CEMEA, EUROPE, NON_EUROPE, NEEA, LACUS,
//    APUS, ANY
//}
//
//public enum HoldCategoryEnum {
//    FRAUD, NPAY, OTHERS
//}
//
//public enum PaymentTypeEnum {
//    FULL, PARTIAL
//}
//
//public enum NetworkEnum {
//    ALL, NA, VISA, MC, RUPAY, AMEX, DISCOVER, DINERS, UPI_NPCI, CHINAUNIONPAY, NCCC, ONUS, PROPRIETARY, JCB,
//    PRIVATE_LABEL, MAESTRO, IBANKING, EBT, UNIONPAYINTERNATIONAL, MERCURY, NETS, BCCARDS, RUPAYINTERNATIONAL
//}
//
//public enum ManulEntryTriggerEnum{
//    INCOMING, OUTGOING
//}
//public enum SwitchSourceEnum {
//    NAC, WEB;
//}
//
//public enum SwitchDestinationEnum {
//    RUPAY, VISA, MC, ONUS, PAYNEXT_ISO, PAYNEXT_WEB, TOUCAN_GLOBAL, TOUCAN_STUB, HDFC_FSS, CCAVENUE_NETBANK_IN,
//
//    NSDL_FSS, IN_NPSTEVOK, AMEX, DISCOVER, DINERS, MERCURY_ISO, EBT_ISO, TOUCAN_ISO, TOUCAN_PREPAID_ISO, RUPAY_WEB,
//    UPI_YESBANK_MGS, TEST;
//
//    public ProviderEnum getProvider() {
//        switch (this) {
//            case PAYNEXT_WEB:
//                return ProviderEnum.CARD_AUTH_PAYNEXT;
//            case HDFC_FSS:
//                return ProviderEnum.CARD_AUTH_HDFC;
//            case NSDL_FSS:
//                return ProviderEnum.CARD_AUTH_NSDL;
//            case RUPAY_WEB:
//                return ProviderEnum.CARD_AUTH_RUPAY_WEB;
//            case TOUCAN_ISO:
//                return ProviderEnum.TOUCAN_ISO;
//            default:
//                return null;
//        }
//    }
//}
//
//public enum AccountTypeEnum {
//    CURRENT, SAVING, OVERDRAFT
//}
//
//public enum RelationshipEnum {
//    EXCELLENT, GOOD, AVERAGE, POOR
//}
//
//public enum StorageEngineTypeEnum {
//    FILE_STORAGE, CLOUD_STORAGE
//}
//
//public enum FileRetentionPolicyEnum {
//    RETAIN_SHORT, RETAIN_NORMAL, RETAIN_LONG, RETAIN_EVER
//}
//
//public enum SortDirectionEnum {
//    ASC, DESC
//}
//
//public enum RebateKindEnum {
//    POST_REBATE, PRE_REBATE
//}
//
//public enum RebateCalculationTypeEnum {
//    FIXED_PERCENTAGE, FIXED_AMOUNT, TIERED_PERCENTAGE, TIERED_AMOUNT, TIERED_AMOUNT_OR_PERCENTAGE
//}
//
//public enum RebateLevelEnum {
//    MERCHANT, CHAIN
//}
//
//public enum RebateOfferedEnum {
//    SURCHARGE, MDR, RENTAL, CASHBACK
//}
//
//public enum AssignmentMethodEnum {
//    RANDOM, QUEUE_SIZE
//}
//
//public enum TcpSocketConnectionEnum {
//    PERSISTENT, TRANSACTIONAL
//}
//
//public enum FixedPerTieredEnum {
//    FIXED, PERCENTAGE, BOTH, HIGHER, LOWER, TIERED, TIERED_TRAN_AMT, TIERED_VOL,
//}
//
//public enum ZoneEnum {
//    EAST, WEST, NORTH, SOUTH
//}
//
//public enum DisputeRecoveryEnum {
//    INITIAL_DISPUTE, DISPUTE_CONFIRMED
//}
//
//public enum PaymentDateTypeEnum {
//    POSTING_DATE, TRANSACTION_DATE
//}
//
//public enum OriginationEnum {
//    ALL, DOMESTIC, INTERNATIONAL
//}
//
////	public enum OrderTypeEnum{
////		MAIL_ORDER,TELEPHONE_ORDER,MANUAL_ENTRY
////	}
//
//public enum SrStatusEnum {
//    OPEN, APPROVED, REJECTED, CLOSED, REOPEN,
//
//    // Need to be removed
//    SLA_CROSSED
//}
//
//public enum SrTalkRmSubType {
//    TALKTORM, OACTIVETERMINALS
//}
//
//public enum PaymentReleaseStatusEnum {
//    PENDING, COMPLETED
//}
//
//public enum RequestStatusEnum {
//    PENDING, COMPLETED, CANCELLED, INPROGRESS
//}
//
//public enum EmailServiceProviderEnum {
//    GMAIL, TWILIO_SENDGRID, NONE, EMAIL_MAILGUN
//}
//
//public enum SMSServiceProviderEnum {
//    SMSCONNEXION, NONE
//}
//
//public enum ServiceRequestTypeEnum {
//    ADD_SECONDARY_OWNER("SrAddSecondaryOwner", ServiceRequestSectionEnum.MERCHANT, "Update Other Owner"),
//    ADDDISPUTE("SRAddDispute", ServiceRequestSectionEnum.MERCHANT, "Add other dispute"),
//    ADDUSER("SrAddUser", ServiceRequestSectionEnum.MERCHANT, "Add User"),
//    SRUPDATEEXTERNALUSER("SrUpdateExternalUser", ServiceRequestSectionEnum.MERCHANT, "SR Update External User"),
//    SRACTIVATEDEACTIVATEUSER("SRACTIVATEDEACTIVATEUSER", ServiceRequestSectionEnum.MERCHANT,
//            "Activate/De-Activate User"),
//    ADDITIONAL_TERMINALS("SrAdditionalTerminal", ServiceRequestSectionEnum.TERMINAL, "Additional terminal"),
//    CHANGE_OF_OWNERSHIP("SrChangeOfOwnership", ServiceRequestSectionEnum.MERCHANT, "Change of ownership"),
//    CHARGEBACK("SrChargeback", ServiceRequestSectionEnum.OTHERS, "Chargeback "),
//    CHARGEBACK_INQ("SrChargebackInq", ServiceRequestSectionEnum.TRAN_N_PYMT, "Chargeback Inquiry"),
//    CONSUMABLES("SrConsumables", ServiceRequestSectionEnum.TERMINAL, "Consumables"),
//    CONTACTDETAILSUPDATE("SrContactDetailUpdate", ServiceRequestSectionEnum.MERCHANT, "Contact details update"),
//    CURRENCY("SrCurrencyChange", ServiceRequestSectionEnum.MERCHANT, "Currency change"),
//    DUPLICATEPAYMENTADVICE("SrDuplicatePayAdvice", ServiceRequestSectionEnum.TRAN_N_PYMT, "Duplicate PA"),
//    DUPLICATESTATEMENT("SrDuplicateStatement", ServiceRequestSectionEnum.TRAN_N_PYMT, "Duplicate Statement"),
//    INTERNET_PAYMENT_GATEWAY("SrInternetPaymentGateway", ServiceRequestSectionEnum.MERCHANT, "Payment Gateway"),
//    KYC("SrKyc", ServiceRequestSectionEnum.MERCHANT, "KYC"),
//    MERCHANT_DEINSTALLATION("SrMerchantDeinstallation", ServiceRequestSectionEnum.MERCHANT,
//            "Merchant De-installation"),
//    NEWMERCHANT("SrNewMerchant", ServiceRequestSectionEnum.OTHERS, "New merchant"),
//    OPERATING_TIMES("SrOperatingTime", ServiceRequestSectionEnum.MERCHANT, "Operating times"),
//    PASSWORD_CHANGE("SrPwdChange", ServiceRequestSectionEnum.MERCHANT, "Password change"),
//    PAYMENT_ACCOUNT("SrPaymentAccount", ServiceRequestSectionEnum.TRAN_N_PYMT, "Payment account"),
//    PAYMENTINQUIRY("SrPaymentEnquiry", ServiceRequestSectionEnum.TRAN_N_PYMT, "Payment inquiry"),
//    PROFILE("SrProfile", ServiceRequestSectionEnum.MERCHANT, "Profile"),
//    RECONISSUE("SrReconissue", ServiceRequestSectionEnum.OTHERS, "Recon issue"),
//    RETRIEVAL_REQUEST("SrRetrievalRequest", ServiceRequestSectionEnum.OTHERS, "Retrival Request"),
//    SRCOMMUNICATION("SrCommunicationChannel", ServiceRequestSectionEnum.MERCHANT, "Communication Channel"),
//    SRMERCHANTCHAIN("SrMerchantChain", ServiceRequestSectionEnum.MERCHANT, "Merchant chain"),
//    STATEMENT_OPTION("SrStatementOptions", ServiceRequestSectionEnum.STMT_N_PA, "Statement options"),
//    TALKTORM("SrTalkRm", ServiceRequestSectionEnum.MERCHANT, "Talk to RM"),
//    TERMINALBREAKDOWN("SrTerminalBreakdown", ServiceRequestSectionEnum.TERMINAL, "Terminal breakdown"),
//    TERMINALDEINSTALLATION("SrTerminalDeInstallation", ServiceRequestSectionEnum.TERMINAL,
//            "Terminal De-installation"),
//    UPDATEDISPUTE("SRUpdateDispute", ServiceRequestSectionEnum.TRAN_N_PYMT, "Update Dispute"),
//    MARKUP_UPDATE("SrMarkupUpdate", ServiceRequestSectionEnum.MERCHANT, "DCC Markup update"),
//    OFFERS("SrOffers", ServiceRequestSectionEnum.TERMINAL, "Offers"),
//    ICA("SRIca", ServiceRequestSectionEnum.TRAN_N_PYMT, "Intl. card accepted"),
//    BLOCK("SrBlockAuth", ServiceRequestSectionEnum.TERMINAL, "Block Auth"),
//    CHAIN_SR_CONTACT_UPDATE("ChainSrContactDetailsUpdate", ServiceRequestSectionEnum.CHAIN,
//            "Contact details update"),
//    CHAIN_SR_DEFAULT_MERCHANT("ChainSrDefaultMerchant", ServiceRequestSectionEnum.CHAIN_MERC, "Default Merchant"),
//    CHAIN_SR_AUTH_BLOCK("ChainSrAuthBlock", ServiceRequestSectionEnum.CHAIN, "Block Auth"),
//    CHAIN_SR_PAYMENT_ACCOUNT("ChainSrPaymentAccount", ServiceRequestSectionEnum.CHAIN, "Payment account"),
//    CHAIN_SR_PAYMENT_OPTION("ChainSrPaymentOption", ServiceRequestSectionEnum.CHAIN_PYMT, "Payment Option"),
//    CHAIN_SR_STATEMENT_OPTION("ChainSrStatementOptions", ServiceRequestSectionEnum.CHAIN_STMT, "Statements"),
//    PAYMENT_OPTION("SrPaymentOption", ServiceRequestSectionEnum.TRAN_N_PYMT, "Payment options"),
//    CHAIN_SR_ADD_CHAIN("ChainSrAddChain", ServiceRequestSectionEnum.CHAIN, "Add Chain"),
//    CONSUMER_OFFERS("SrConsumerOffers", ServiceRequestSectionEnum.TERMINAL, "Consumer Offers"),
//    TECHNICAL_ISSUE("SrTechnicalIssue", ServiceRequestSectionEnum.OTHERS, "Technical issue"),
//    USER_REQUEST("SrUser", ServiceRequestSectionEnum.USER, "User Requests"),
//    REGISTER_BATCH_PAY("SRRegisterBatchPay", ServiceRequestSectionEnum.TERMINAL, "Batch Pay Request"),
//    DE_REGISTER_BATCH_PAY("SRDeRegisterBatchPay", ServiceRequestSectionEnum.TERMINAL,
//            "De-Register Batch Pay Request"),
//    TERMINAL_ACTIVE_INACTIVE("SrTerminalActiveInactive", ServiceRequestSectionEnum.TERMINAL,
//            "Activate/ deactivate Terminal"),
//    MERCHANT_ACTIVE_INACTIVE("SrMerchantActiveInactive", ServiceRequestSectionEnum.MERCHANT,
//            "Activate/ deactivate Merchant"),
//    SR_POS_TERMINAL_INITIALIZATION("SRPOSTerminalInitialization", ServiceRequestSectionEnum.TERMINAL,
//            "POS Initialization"),
//    ADD_MERCHANT_AND_TERMINAL_PROVIDERS("SrAddProviders", ServiceRequestSectionEnum.TERMINAL, "Add Providers"),
//    MERCHANT_TERMINAL_CONSUMER("SrMerchantTerminalConsumer", ServiceRequestSectionEnum.TERMINAL,
//            "Merchant Terminal Consumer");
//
//    private String associatedClass;
//    private ServiceRequestSectionEnum section;
//    private String description;
//
//    private ServiceRequestTypeEnum(String associatedClass, ServiceRequestSectionEnum section, String description) {
//        this.associatedClass = associatedClass;
//        this.section = section;
//        this.description = description;
//    }
//
//    public Class<?> getAssociatedClass() {
//        try {
//            return Class.forName("com.toucan.app.model.servicerequest.".concat(associatedClass));
//        } catch (ClassNotFoundException e) {
//            logger.error("An error occurred: {}", e.getMessage(), e);
//            return Object.class;
//        }
//    }
//
//    public ServiceRequestSectionEnum getSection() {
//        return this.section;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//}
//
//public enum ProfileSrSubType {
//    RATE_REVISION
//}
//
//public enum OperatingTimesSrSubTypeEnum {
//    MERCHANT_LEVEL, TERMINAL_LEVEL
//}
//
//public enum SubTypePayOptEnum {
//    CREDIT_ACC_PAY_MODE, DEBIT_ACC_PAY_MODE
//}
//
//public enum PaymentAccountSrSubType {
//    CREDIT_ACCOUNT, DEBIT_ACCOUNT, CHAIN_CREDIT_ACCOUNT, CHAIN_DEBIT_ACCOUNT,
//}
//
//public enum RecName {
//    RE_PRESENTMENT_ACCEPTANCE, REFUND_CHARGEBACK, CHARGEBACK_REVERSAL, CHARGEBACK_REFUND_REVERSAL,
//    SECOND_CHARGEBACK_REVERSAL, CHARGEBACK, SECOND_CHARGEBACK, RETRIEVAL_REQUEST, FRIST_INQUIRY, SECOND_INQUIRY,
//    AUTHORIZATION_CANCELLATION_REQUEST, PRE_COMPLIANCE_ACCEPTANCE, COMPLIANCE_ACCEPTANCE, GOOD_FAITH_ACCEPTANCE,
//    MEMBER_FUND_COLLECTION, MEMBER_FUND_DISBURSEMENT, NPCIFEE_COLLECTION, NPCIFEE_DISBURSEMENT, PRESENTMENT,
//    PRESENTMENT_REVERSAL, OFFLINE_PRESENTMENT, VOID, OFFLINE_REFUND, REFUND, SMS_TIPAND_SURCHARGE,
//    CREDIT_ADJUSTMENT, DEBIT_ADJUSTMENT, CHARGEBACK_ACCEPTANCE, RE_PRESENTMENT, HEADER, TRAILER_RECORD,
//    RETRIEVAL_REQUEST_FULFILLMENT, RETRIEVAL_REQUEST_NOTFULFILLMENT, FIRST_INQUIRY_RESPONSE,
//    SECOND_INQUIRY_RESPONSE, PRE_ARBITRATION_ACCEPTANCE, ARBITRATION_ACCEPTANCE,
//    AUTHORIZATION_CANCELLATION_ACCEPTANCE, ONUS_TRANSACTION, Chargeback_Deemed_Acceptance,
//    Pre_Arbitration_Deemed_Acceptance, AUTHORIZATION, GOOD_FAITH, SMS_AUTHORIZATION, DMS_AUTHORIZATION,
//    RETRIEVAL_REQUEST_ACKNOWLEDGMENT, FIRST_CHARGEBACK, ARBITRATION_CHARGEBACK, SECOND_PRESENTMENT, FEE_COLLECTION,
//    CASH_DISBURSEMENTS, CASH_DISBURSEMENTS_REVERSAL, REFUND_REVERSAL, SMS_TIP, SMS_SURCHARGE,
//    MEMBER_FOUND_COLLECTION, MEMBER_FOUND_DISBURSEMENT, MC_FEE
//
//}
//
//public enum RecNameJV {
//    OUTGOING_PRESENTMENT("Outgoing Presentment"), INCOMING_PRESENTMENT("Incoming Presentment"),
//    OUTGOING_RE_PRESENTMENT("Outgoing Re-Presentment"), INCOMING_RE_PRESENTMENT("Incoming Re-Presentment"),
//    OUTGOING_MEMBER_FOUND_COLLECTION("Outgoing Member Found Collection"),
//    INCOMING_MEMBER_FOUND_COLLECTION("Incoming Member Found Collection"),
//    OUTGOING_MEMBER_FOUND_DISBURSEMENT("Outgoing Member Found Disbursement"),
//    INCOMING_MEMBER_FOUND_DISBURSEMENT("Incoming Member Found Disbursement"),
//    INCOMING_PRESENTMENT_FEE("Incoming Presentment Fee"),
//    INCOMING_RE_PRESENTMENT_FEE("Incoming Re-Presentment Fee"), INCOMING_CHARGEBACK("Incoming Chargeback"),
//    INCOMING_CHARGEBACK_FEE("Incoming Chargeback Fee");
//
//    private String description;
//
//    private RecNameJV(String description) {
//        this.description = description;
//    }
//
//    public String getDescription() {
//        if (this.description == null) {
//            return "";
//        }
//        return this.description;
//    }
//
//}
//
//public enum SubTypeAddSeconContactEnum {
//    ADD_OWNER, DELETE_OWNER
//}
//
//public enum SubTypeCommunicationEnum {
//    CHANNEL_UPDATE, EVENT_UPDATE
//}
//
//public enum SrPriorityEnum {
//    CRITICAL, MEDIUM, HIGH, LOW
//}
//
//public enum SrSource {
//    IVR, SS_WEB, OPS_WEB, SS_MAPP, OPS_MAPP,
//
//    // need to remove
//    MAPP, WEB
//}
//
//public enum ServiceRequestSubTypeEnum {
//    TERMINAL_DOESNT_SWITCHED_ON, TERMINAL_DOESNT_CHARGE, CHARGE_SLIP_DOESNT_GENERATED, NETWORK_ISSUE,
//    TERMINAL_REPLACEMENT, SETTLEMENT_NOT_HAPPENING, OTHERS
//}
//
//public enum SubTypeReconissueEnum {
//    INTERCHANGE_AMOUNT_ISSUE, TRANSACTION_NOT_FOUND, TRANSACTION_DISCREPANCY
//}
//
//public enum SubTypeDuplicateStatEnum {
//    CURRENT, PREVIOUS, STATEMENT_DATE_RANGE
//}
//
//public enum SubTypeTerminalBreakdownEnum {
//    TERMINAL_DOESNT_SWITCHED_ON, TERMINAL_DOESNT_CHARGE, CHARGE_SLIP_DOESNT_GENERATED, NETWORK_ISSUE,
//    TERMINAL_REPLACEMENT, SETTLEMENT_NOT_HAPPENING, OTHERS
//}
//
//public enum SubTypeKycEnum {
//    OWNER1_PROOF, OWNER2_PROOF, ESTABLISHMENT_PROOF
//}
//
//public enum SubTypeMerchantChainEnum {
//    ADD_CHAIN, DELETE_CHAIN, ADD_NEW_MERCHANT, DELETE_MERCHANT, ADD_EXISTING_MERCHANT, ADD_PARENT_CHAIN,
//    CHAIN_SR_DELETE_CHAIN, CHAIN_SR_ADD_NEW_MERCHANT, CHAIN_SR_DELETE_MERCHANT, CHAIN_SR_ADD_EXISTING_MERCHANT,
//    CHAIN_SR_ADD_PARENT_CHAIN
//}
//
//public enum SubTypeChargebackInqEnum {
//    GOOD_ALREADY_DELIVERED, CHARGESLIP_NOT_PRESENT, OTHERS
//}
//
//public enum SubTypePayInquiryEnum {
//    PAYMENT_NOT_RECEIVED, PAYMENT_NOT_MATCHING_WITH_PA, TRANSACTION_NOT_INCLUDED
//}
//
//public enum DeliveryOptionEnum {
//    SELF_PICKUP, DELIVERY
//}
//
//public enum SubTypeContactDetailUpdateEnum {
//    PRIMARY_DETAILS, SECONDARY_DETAILS, ESTABLISHMENT, CONTACT_PERSON, REGISTERED, TERMINAL
//}
//
//public enum SubTypeTerminalDeinstallationEnum {
//    ANOTHER_ACQUIRER_INSTALLATION, BUSINESS_CLOSURE
//}
//
//public enum SubTypeBlockAuthEnum {
//    PAYMENT_BLOCK, MERCHANT_AUTH_BLOCK, TERMINAL_AUTH_BLOCK
//}
//
//public enum SubTypeNewMerchantEnum {
//    PG_MERCHANT, POS_MERCHANT
//}
//
//public enum EntitlementEnum {
//    URL, MESSAGEID,
//}
//
//public enum MessageTypeEnum {
//    SINGLE, DUAL, BOTH
//}
//
//public enum StatisFrequencyEnum {
//    TODAY, CURRENTWEEK, LAST7DAY, CURRENTMONTH, LAST30DAYS, LAST6WEEKS, LAST12MONTHS, PREVIOUSMONTHS, CURRENTYEAR,
//    LTD, CURRENTYEARMONTH, CURRENTMONTHALLWEEKS, CURRENTYEARALLMONTHS, LAST90DAYS, YESTERDAY
//}
//
//public enum BinTypeEnum {
//    OFFUS, ONUS,
//}
//
//public enum CRUDEnum {
//    CREATE, UPDATE, QUERY, DELETE, LIST, SERVICE, NOTUSED, SAVE_DRAFT, SUBMIT, POSTING, UPD_APPROVE, UPD_REJECT,
//    UPD_COMPARE
//
//}
//
//public enum CreditOrDebitEnum {
//    CREDIT, DEBIT
//}
//
//public enum CardTypeEnum {
//    CREDIT, DEBIT, PREPAID, WALLET, ALL, NA, DEFERRED_DEBIT, CHARGE, DELAYED_DEBIT, UPI_NPCI
//}
//
//public enum FrequencyEnum {
//    DAILY, STATEMENTDAY, MONTHLY, QUARTERLY
//}
//
//public enum OTPChannelEnum {
//    SMS, EMAIL, BOTH
//}
//
//public enum LanguageEnum {
//    ENGLISH, HINDI, RUSSIAN, ITALIAN, CHINESE, PORTUGUESE, JAPANESE
//}
//
//public enum SearchServiceProviderEnum {
//    INTERNAL, SOLR, SOLR_AND_INTERNAL
//}
//
//public enum MailProtocalEnum {
//    POP3, SMTP, POP3S
//}
//
//public enum TopicEnum {
//    CRUD_MODEL, STAT_UPDATE, MER_ONB_REQ, MER_ONB_RES, COMM_TOPIC, TL_ALLPAY_UPD, MER_ALL_PAY, COMM_HIGH, MAINT_LOG,
//    TERM_TRACKER, FILE_UPLOAD, TRACE_LOG, DATA_DOWNLOAD, CALLBACK, MERC_POSTING_SEQ, CREATE_AUTH_LOG,
//    SOCKET_RESPONSE
//}
//
//public enum ErrorCodeEnum {
//
//    ERR_TECH_001("Invalid Request"), ERR_TECH_002("Request Method Is Not Defined"),
//    ERR_TECH_003("Create Sever Error"), ERR_TECH_004("Record Not Found"), ERR_TECH_005("Internal Error Occurred"),
//    ERR_TECH_006("No Api Allowed"), ERR_TECH_007("Duplicate Record"), ERR_TECH_008("Invalid Message Data"),
//    ERR_TECH_009("Message Validation Fail"), ERR_TECH_010("Message Conversion Exception"),
//    ERR_TECH_011("Function Not Allowed"), ERR_TECH_012("LogIn Invalid Request"),
//    ERR_TECH_013("LogIn Invalid Session"), ERR_TECH_014("LogIn Internal Error"),
//    ERR_TECH_015("LogIn Internal Error"), ERR_TECH_016("LogIn Invalid User"), ERR_TECH_017("LogIn Invalid User"),
//    ERR_TECH_018("LogOut Invalid Request"), ERR_TECH_019("LogOut Invalid Session"),
//    ERR_TECH_020("LogOut Internal Error"), ERR_TECH_021("Record Exist Sever Errors"),
//    ERR_TECH_022("Delete By Id Sever Error"), ERR_TECH_023("Get By Id Sever Error"),
//    ERR_TECH_025("Present Id Record Exist Error"), ERR_ACQ_001("Maker Priv Missing"),
//    ERR_ACQ_002("Checker Priv Missing"), ERR_ACQ_003("Validation Fail Currency Doesnot Match"),
//    ERR_ACQ_004("Posting Exception"), ERR_TECH_024("Null Object Found"), ERR_TECH_039("Terminal Inactive"),
//    ERR_ACQ_005("Invalid Merchant Id"), ERR_ACQ_006("Invalid Otp"), ERR_ACQ_007("Bin Found As Counterfeit"),
//    ERR_ACQ_008("No Mid Found"), ERR_ACQ_009("Terminal Invalid"), ERR_TECH_026("External Server Error Occurred"),
//    ERR_TECH_027("Invalid Data Type Provided"), ERR_TECH_028("Original Record Not Found"),
//    ERR_ACQ_010("Incorrect Refund Amount"), ERR_ACQ_011("Refund Amount Exceeds Transaction Amount"),
//    ERR_TECH_029("Unable To Locate Record"), ERR_TECH_030("Invalid Transaction"),
//    ERR_TECH_031("Record Already Existing In File"), ERR_TECH_041("Email Id Verified"),
//    ERR_TECH_032("Object Received As Null"), ERR_TECH_033("Base Url Not Present"), ERR_TECH_034("No Encoded Value"),
//    ERR_TECH_042("Password Changed"), ERR_ACQ_012("Invalid Mti Received"),
//    ERR_ACQ_013("Terminal Received As Manual"), ERR_ACQ_014("No Transactions Found"),
//    ERR_ACQ_015("Declined Transaction"), ERR_ACQ_016("Transaction Not Cleared"), ERR_TECH_035("Timeout Error"),
//    ERR_ACQ_017("Terminal Blocked"), ERR_ACQ_018("Emi No Support Term"), ERR_ACQ_019("Invalid Id"),
//    ERR_ACQ_020("App Invalid Card Number"), ERR_ACQ_021("Otp Limit Exceeded"), ERR_ACQ_022("Sr Already Closed"),
//    ERR_TECH_036("App Update V1"), ERR_TECH_037("App User Not Present"), ERR_TECH_038("Password Reset Successfull"),
//    ERR_ACQ_023("App Invalid Password Received"), ERR_ACQ_024("User Not Present"), ERR_ACQ_025("Invalid Card Bin"),
//    ERR_ACQ_026("Scheme Ctrl Invalid"), ERR_ACQ_027("Txn Not Allowed"), ERR_ACQ_028("Acq Id Invalid"),
//    ERR_ACQ_029("Forwarding Id Invalid"), ERR_TECH_040("Bitmap Error"), ERR_ACQ_030("Fee Amount Req"),
//    ERR_ACQ_031("Cashback Amount Req"), ERR_ACQ_032("Emi Amount Req"), ERR_ACQ_033("Emi Margin Amount Req"),
//    ERR_ACQ_034("Emi Tenure Req"), ERR_ACQ_035("Surcharge Amount Req"), ERR_ACQ_036("Tip Amount Req"),
//    ERR_ACQ_037("Invalid Dispute Amount"), ERR_ACQ_038("Multiple Settlement Not Allowed"),
//    ERR_ACQ_039("Socket Not Connected"), ERR_ACQ_040("Orig Request Declined"), ERR_ACQ_041("Modelenum Notderived"),
//    ERR_ACQ_042("Invalid Amount"), ERR_TECH_043("Format Error"), ERR_ACQ_043("Sr Dispute Already Raised"),
//    ERR_ACQ_044("Sr Already Approved"), ERR_TECH_044("Socket Connect Not Found"),
//    ERR_ACQ_045("Merchant Not Active"), ERR_ACQ_046("Dispute Already Recovered"),
//    ERR_ACQ_047("Invalid Searchquery"), ERR_TECH_045("Timeout Encountered"),
//    ERR_ACQ_048("Offer Not Found For Merchant"), ERR_ACQ_049("Sr Request Validation Failed"),
//    ERR_ACQ_050("Merchant Offer Code Not Be Null"), ERR_ACQ_051("Invalid Dcc"), ERR_TECH_046("Incomplete Data"),
//    ERR_ACQ_052("Payer Or Payee Does Not Exist"), ERR_ACQ_053("Acquirer Does Not Support The Request"),
//    ERR_ACQ_054("Frm Reject"), ERR_TECH_047("Retry Transaction"), ERR_ACQ_055("Success Txn"),
//    ERR_ACQ_056("Alliance Partner Does Not Support Ica"), ERR_ACQ_057("Maker Checker Rejected"),
//    ERR_ACQ_058("Checker group Time Expired"), ERR_ACQ_059("Dispute Outstanding Found"),
//    ERR_ACQ_060("Checker Already Rejected"),
//    ERR_ACQ_061("Pre Auth compeletion amount should be less than or equal to Pre Auth Request Amount"),
//    ERR_ACQ_062("Dispute time expired"), ERR_ACQ_063("already outsatanding cycle found"),
//    ERR_ACQ_064("already outsatanding RR found without acknowledgement"),
//    ERR_ACQ_065("already outsatanding Fee entry found"), ERR_ACQ_066("prearbitration_acceptance cycle not found"),
//    ERR_ACQ_067("please provide sms transaction to fee type"),
//    ERR_ACQ_068("Pre Auth Transaction not able to make Advice Transaction"),
//    ERR_ACQ_069("Tip Amount should be lessthan 20 percent of Transcation Amount"),
//    ERR_ACQ_070("Surcharge Amount should be lessthan 3 percent of Transcation Amount"),
//    ERR_ACQ_071("Invalid Reasoncode"),
//    ERR_ACQ_072("credit and debit adjustment is not applicable for chargeback transactions"),
//    ERR_ACQ_073("Unsettled transaction"),
//    ERR_ACQ_074("CardNumber is too short"),
//    ERR_ACQ_075("FullPartial Indicator is not found"),
//    ERR_ACQ_076("chargeback not yet acknowledged");
//    private String description;
//
//    private ErrorCodeEnum(String description) {
//        this.description = description;
//    }
//
//    public String getDescription() {
//        if (this.description == null) {
//            return "";
//        }
//        return this.description;
//    }
//
////		SOS_0001_INVALID_REQUEST, SOS_0002_REQUEST_METHOD_NOT_DEFINED, SOS_0003_CREATE_SEVER_ERROR,
////		SOS_0004_RECORD_NOT_FOUND, SOS_0005_INTERNAL_ERROR_OCCUR, SOS_0006_NO_API_ALLOWED, SOS_0007_DUPLICATE_RECORD,
////		SOS_0008_INVALID_MESSAGE_DATA, SOS_0008_MESSAGE_VALIDATION_FAIL, SOS_0009_MESSAGE_CONVRSION_EXCEPTION,
////		SOS_0010_FUNC_NOT_ALLOWED, LOGIN_0001_INVALID_REQUEST, LOGIN_0002_INVALID_SESSION, LOGIN_0003_INTERNAL_ERROR,
////		LOGIN_0004_INTERNAL_ERROR, LOGIN_0005_INVALID_USER, LOGIN_0006_INVALID_USER, LOGOUT_0001_INVALID_REQUEST,
////		LOGOUT_0002_INVALID_SESSION, LOGOUT_0003_INTERNAL_ERROR, SOS_0010_RECORDEXIST_SEVER_ERROR,
////		SOS_0011_DELBYID_SEVER_ERROR, SOS_0012_GETBYID_SEVER_ERROR, SOS_0013_PRESETID_RECORDEXIST_ERROR,
////		SOS_0014_MAKER_PRIV_MISSING, SOS_0016_CHECKER_PRIV_MISSING, VALIDATION_FAIL_CURRENCY_DOESNOT_MATCH,
////		POSTING_EXCEPTION, NULLOBJECTFOUND, TERMINAL_INACTIVE, INVALID_MERCHANT_ID, INVALID_OTP,
////		BIN_FOUND_AS_COUNTERFEIT, NO_MID_FOUND, TERMINAL_INVALID, EXTERNAL_SERVER_ERROR_OCCURRED,
////		INVALID_DATA_TYPE_PROVIDED, ORIGINAL_RECORD_NOT_FOUND, INCORRECT_REFUND_AMOUNT,
////		REFUND_AMOUNT_EXCEEDS_TRANSACTION_AMOUNT, UNABLE_TO_LOCATE_RECORD, INVALID_TRANSACTION,
////		RECORD_ALREADY_EXISTING_IN_FILE, EMAIL_ID_VERIFIED, OBJECT_RECEIVED_AS_NULL, BASE_URL_NOT_PRESENT,
////		NO_ENCODED_VALUE, PASSWORD_CHANGED, INVALID_MTI_RECEIVED, TERMINAL_RECEIVED_AS_MANUAL, NO_TRANSACTIONS_FOUND,
////		DECLINED_TRANSACTION, TRANSACTION_NOT_CLEARED, TIMEOUT_ERROR, TERMINAL_BLOCKED, EMI_NO_SUPPORT_TERM, INVALID_ID,
////		APP_INVALID_CARD_NUMBER, OTP_LIMIT_EXCEEDED, SR_ALREADY_CLOSED, APP_UPDATE_V1, APP_USER_NOT_PRESENT,
////		PASSWORD_RESET_SUCCESSFULL, APP_INVALID_PASSWORD_RECEIVED, USER_NOT_PRESENT, INVALID_CARD_BIN,
////		SCHEME_CTRL_INVALID, TXN_NOT_ALLOWED, ACQ_ID_INVALID, FORWARDING_ID_INVALID, BITMAP_ERROR, FEE_AMOUNT_REQ,
////		CASHBACK_AMOUNT_REQ, EMI_AMOUNT_REQ, EMI_MARGIN_AMOUNT_REQ, EMI_TENURE_REQ, SURCHARGE_AMOUNT_REQ,
////		TIP_AMOUNT_REQ, INVALID_DISPUTE_AMOUNT, MULTIPLE_SETTLEMENT_NOT_ALLOWED, SOCKET_NOT_CONNECTED,
////		ORIG_REQUEST_DECLINED, MODELENUM_NOTDERIVED, INVALID_AMOUNT, FORMAT_ERROR, SR_DISPUTE_ALREADY_RAISED,
////		SR_ALREADY_APPROVED, SOCKET_CONNECT_NOT_FOUND, MERCHANT_NOT_ACTIVE, DISPUTE_ALREADY_RECOVERED,
////		INVALID_SEARCHQUERY, TIMEOUT_ENCOUNTERED, OFFER_NOT_FOUND_FOR_MERCHANT, SR_REQUEST_VALIDATION_FAILED,
////		MERCHANT_OFFER_CODE_NOT_BE_NULL, INVALID_DCC, INCOMPLETE_DATA, PAYER_OR_PAYEE_DOES_NOT_EXIST,
////		ACQUIRER_DOES_NOT_SUPPORT_THE_REQUEST, FRM_REJECT, RETRY_TR 00_SUCCESS_TXN,
////		ALLIANCE_PARTNER_DOES_NOT_SUPPORT_ICA, MAKER_CHECKER_REJECTED, CHECKERGROUP_TIME_EXPIRED,
////		DISPUTE_OUTSTANDING_FOUND,CHECKER_ALREADY_REJECTED
//}
//
//public enum MessageCodeEnum {
//    LOGIN_0001_WITH_OTP, REGISTER_0001_WITH_OTP, LOGIN_002_SUCCESS, REQUEST_001_SUCCESS
//}
//
//public enum AuthErrorCodeEnum {
//
//    T001("Check Status Record not found Contact your Merchant/Acquirer", "30"),
//    T002("Merchant setup issue Decline", "58"), T003("Merchant setup issue Decline", "58"),
//    T004("Invalid Transaction currency Decline", "05"), T005("Missing Transaction Amount Decline", "05"),
//    T006("Invalid Transaction Amount Decline", "05"), T007("Transaction Type Invalid Decline", "05"),
//    T008("Could not process request Cancel and Retry", "05"),
//    T009("Could not process request Cancel and Retry", "05"),
//    T010("Could not process request  Cancel and Retry", "05"), T011("PAN Entry Missing Contact Tech Support", "30"),
//    T012("PIN Entry Missing Contact Tech Support", "30"),
//    T013("POS Condition code Missing Contact Tech Support", "30"),
//    T014("Invoice number Missing Contact Tech Support", "30"),
//    T015("From Account Missing Contact Tech Support", "30"), T016("to Account Missing Contact Tech Support", "30"),
//    T017("Could not process request Access Denied", "05"), T018("MCC Missing Contact Tech Support", "30"),
//    T019("Transaction not allowed Contact your Merchant /Acquirer", "30"),
//    T020("Encryption Indicator Missing Contact Tech Support", "30"), T021("PAN missing Contact Tech Support", "30"),
//    T022("Contact Tech Support , Could not process missing bin ", "30"),
//    T023("DCC Markup missing Contact Tech Support", "30"),
//    T024("DCC Markup missing Contact your Merchant/Acquirer", "30"),
//    T025("Could not process DCC Contact Tech Support", "30"), T026("DCC not allowed Retry without DCC", ""),
//    T027("Retry with another payment option, Could not process request for ", "05"),
//    T028("Could not process Verify Card data and Retry", "05"), T029("Could not process Decline", "05"),
//    T030("Transaction Type Invalid Contact Tech Support", "30"),
//    T031("Card not allowed for this transactionRetry with another payment  option", ""),
//    T032("System Param missing report to Merchant/Acquirer Retry with another payment option", "05"),
//    T033("System Param missing report to Merchant/Acquirer Retry with another payment option", "05"),
//    T034("System Param missing report to Merchant/Acquirer Retry with another payment option", "05"),
//    T035("System Param missing report to Merchant/Acquirer Retry with another payment option", "05"),
//    T036("DCC not allowed Retry without DCC", "05"),
//    T037("PreAuth Not Found Could not complete Contact Tech Support", "30"),
//    T038("PreAuth already Reversed/Refunded Request Declined", "05"),
//    T039("PreAuth already Completed Request Declined", "05"),
//    T040("PreAuth was not approved Request Declined", "05"),
//    T041("PreAuth request input error Contact Tech Support", "30"),
//    T042("PreAuth Not found Could not complete Contact Tech Support", "30"),
//    T043("Missing Data Contact Tech Support", "30"), T044("Invalid Data Contact Tech Support", "30"),
//    T045("Missing Data Contact Tech Support", "30"), T046("Invalid Data Contact Tech Support", "30"),
//    T047("EMI not enabled for this Terminal Retry without EMI option", "05"),
//    T048("EMI data missing Contact Tech Support", "30"), T049("EMI Amount Invalid Contact Tech support", "30"),
//    T050("EMI data missing Contact Tech Support", "30"), T051("EMI margin Invalid Contact Tech support", "30"),
//    T052("EMI tenure missing Contact Tech support", "30"), T053("EMI tenure Invalid Contact Tech support", "30"),
//    T054("Surcharge data missing Contact Tech support", "30"),
//    T055("Surcharge values should be greater than zero Retry with correct inputs", "05"),
//    T056("Tip data missing Contact Tech support", "30"),
//    T057("Tip values should be greater than zero Retry with correct inputs", "05"),
//    T058("Refund original Invoice missing Retry with correct inputs", "05"),
//    T059("Refund Amount missing Retry with correct inputs", "05"), T060("Refund Amount exceeded Decline", "05"),
//    T061("Transaction Not Found Could not Refund Contact Tech Support", "30"),
//    T062("Refund Amount exceeded Decline", "05"), T063("Refund FRM payment status reject Decline", ""),
//    T064("Refund FRM clearing status reject Decline", ""), T065("Refund FRM daily limit reject Decline", ""),
//    T066("Refund FRM monthly limit reject Decline", ""), T067("Refund FRM use country reject Decline", ""),
//    T068("Reversal original reference missing Retry with correct inputs", "05"),
//    T069("Transaction Not Found Could not Reverse Contact Tech Support", "30"),
//    T070("Transaction Not Found Could not Reverse Contact Tech Support", "30"),
//    T071("Reversal not allowed for non Approved transaction Request Declined", "05"),
//    T072("Transaction Not Found Could not Reverse Contact Tech Support", "30"),
//    T073("Adjustment Amount missing Retry with correct inputs", "05"),
//    T074("Adjustment Type Debit or Credit missing Retry with correct inputs", "30"),
//    T075("Adjustment not allowed for noncleared transaction Decline", "05"),
//    T076("Card Seq missing Contact Tech support", "30"), T077("Chip data missing Contact Tech support", "30"),
//    T078("Track data missing Contact Tech support", "30"),
//    T079("Card Present data incorrect Contact Tech Support", "30"),
//    T080("Cardholder Auth method incorrect Contact Tech support", "30"),
//    T081("Pin data missing Contact Tech support", "30"), T082("Pin data missing Contact Tech support", "30"),
//    T083("UID data missing Contact Tech support", "30"), T084("Track data missing Contact Tech support", "30"),
//    T085("Incorrect Track received Contact Tech support", "30"),
//    T086("Biometric data missing Contact Tech support", "30"),
//    T087("Track data missing Contact Tech support", "30"), T088("Cashback data missing Contact Tech Support", "30"),
//    T089("Cashback data cannot be greater than Transaction Amount Decline", "30"),
//    T090("Cardholder Present data incorrect Contact Tech Support", "30"),
//    T091("Card Present data incorrect Contact Tech Support", "30"),
//    T092("Pin data missing Contact Tech support", "30"),
//    T093("Cash@POS terminal allowed only on POS Decline", "30"),
//    T094("Cardholder Present data incorrect Contact Tech Support", "30"),
//    T095("Card Present data incorrect Contact Tech Support", "30"),
//    T096("Pin data missing Contact Tech Support", "30"),
//    T097("EMI txn allowed only in Merchant currency Decline", "30"),
//    T098("Cardholder auth method incorrect for Pin based request Contact Tech Support", "30"),
//    T099("Track missing for card present value Contact Tech Support", "30"),
//    T100("Transaction Type code incorrect for Ecom Contact Tech support", "30"),
//    T101("Incorrect PAN Entry for Ecom Contact Tech support", "30"),
//    T102("Incorrect Pin Entry for Ecom Contact Tech support", "30"),
//    T103("Missing Card Expiry for Ecom Contact Tech support", "30"),
//    T104("Missing verification code for Ecom Contact Tech support", "30"),
//    T105("Incorrect Cardholder Present data for Ecom Contact Tech support", "30"),
//    T106("Incorrect Card data input mode for Ecom Contact Tech support", "30"),
//    T107("Incorrect card present data for Ecom Contact Tech support", "30"),
//    T108("Incorrect Terminal Operating Environment Contact Tech support", "30"),
//    T109("Incorrect cardholder auth method for Ecom Contact Tech support", "30"),
//    T110("Incorrect card data input capability for Ecom Contact Tech support", "30"),
//    T111("Incorrect ECI for Ecom Contact Tech Support", "30"),
//    T112("Missing ECI for Ecom Contact Tech Support", "30"),
//    T113("Missing Transaction ID for Ecom Contact Tech Support", "30"),
//    T114("Incorrect cardholder auth method for Ecom Contact Tech Support", "30"),
//    T115("Missing IP for cardholder auth entity for Ecom Contact Tech Support", "30"),
//    T116("Missing country code for cardholder auth entity for Ecom Contact Tech support", "30"),
//    T117("Missing ICS1 for cardholder auth entity for Ecom Contact Tech support", "30"),
//    T118("Missing ICS2 for cardholder auth entity for Ecom Contact Tech support", "30"),
//    T119("Transaction Type code incorrect for IVR Contact Tech support", "30"),
//    T120("Incorrect PAN Entry for IVR Contact Tech support", "30"),
//    T121("Incorrect PIN Entry for IVR Contact Tech support", "30"),
//    T122("Missing card expiry for IVR Contact Tech support", "30"),
//    T123("Missing verification code for IVR Contact Tech support", "30"),
//    T124("Incorrect cardholder present data for IVR Contact Tech support", "30"),
//    T125("Incorrect card data input mode for IVR Contact Tech support", "30"),
//    T126("Incorrect card present data for IVR Contact Tech support", "30"),
//    T127("Incorrect Terminal Operating Environment for IVR Contact Tech Support", "30"),
//    T128("Incorrect cardholder auth method for IVR Contact Tech Support", "30"),
//    T129("Incorrect card data input capability for IVR Contact Tech Support", "30"),
//    T130("Incorrect ECI for IVR Contact Tech Support", "30"),
//    T131("Missing ECI for IVR Contact Tech Support", "30"),
//    T132("Missing Transaction ID for IVR Contact Tech Support", "30"),
//    T133("Transaction Type code incorrect for MoTo Contact Tech support", "30"),
//    T134("Incorrect PAN Entry for MoTo Contact Tech support", "30"),
//    T135("Incorrect PIN Entry for MoTo Contact Tech support", "30"),
//    T136("Missing card expiry for MoTo Contact Tech support", "30"),
//    T137("Missing verification code for MoTo Contact Tech support", "30"),
//    T138("Incorrect cardholder present data for MoTo Contact Tech support", "30"),
//    T139("Incorrect card data input mode for MoTo Contact Tech support", "30"),
//    T140("Incorrect card present data for MoTo Contact Tech support", "30"),
//    T141("Incorrect Terminal Operating Environment for MoTo Contact Tech Support", "30"),
//    T142("Incorrect cardholder auth method for MoTo Contact Tech Support", "30"),
//    T143("Incorrect card data input capability for MoTo Contact Tech Support", "30"),
//    T144("Incorrect ECI for MoTo Contact Tech Support", "30"),
//    T145("Missing ECI for MoTo Contact Tech Support", "30"),
//    T146("Missing Transaction ID for MoTo Contact Tech Support", "30"),
//    T147("Missing card expiry Retry with correct inputs", "05"),
//    T148("Incorrect format data Contact Tech Support", "30"), T149("Missing Track data Contact Tech Support", "30"),
//    T150("Incorrect POS Cond code Contact Tech Support", "30"),
//    T151("Incorrect data for Ecom Contact Tech Support", "30"),
//    T152("Reversal Replacement Amount Exceeds Retry with correct input", "05"),
//    T153("Reversal original reference missing Retry with correct inputs", "05"),
//    T154("Missing cardholder auth method for PIN request Contact Tech Support", "30"),
//    T155("Incorrect cardholder auth method for PIN request Contact Tech Support", "30"),
//    T156("Invalid param received Contact Tech support", "30"),
//    T157("Missing Track data Contact Tech support", "30"),
//    T158("Missing card expiry or card sequence Retry with correct inputs", "05"),
//    T159("Missing chip data Contact Tech support", "30"), T160("Invalid param received Contact Tech support", "30"),
//    T161("Invalid param received Contact Tech support", "30"),
//    T162("Missing chip or pin data Contact Tech support", "30"), T163("Auth Web API connection error", "99"),
//    T164("FRM match been found. Please contact Tech support", "30"),
//    T165("FNS missing - Retry with correct input", "30"),
//    T166("Pre Auth compeletion amount should be less than or equal to Pre Auth Request Amount", "30"),
//    T167("Terminal status is inactive", "30"), T168("Corrected MCC for Cash Disburstment", "57"),
//    T169("Error Message - ", "30"),
//
//    U001("Suspect fraud based on Risk Score by Remitter - 59", "05"), U002("MPIN not set by Customer - AM", "05"),
//    U003("Registered mobile number linked to account changed/removed - B1", "05"),
//    U004("Transaction not permitted to the account - B3", "05"), U005("Payment details mismatch - B6", "05"),
//    U006("Compliance error - Acquirer - CA", "05"), U007("Compliance error - Issuer - CI", "05"),
//    U008("Duplicate Reference Number - Beneficiary - DF", "05"),
//    U009("Duplicate Reference Number - Remitter - DT", "05"), U010("Bank HSM down - Remitter - HS", "05"),
//    U011("Debit Amount not blocked for customer - IC", "05"),
//    U012("Debit Amount greater than blocked amount - ID", "05"), U013("Inadequate funds in account - IE", "05"),
//    U014("Unable to process due to internal exception - Beneficiary - IR", "05"),
//    U015("Suspect fraud based on Risk Score by Remitter - K1", "05"),
//    U016("Unable to process credit from Bank Pool  - LC", "05"),
//    U017("Unable to process debit to Bank Pool - LD", "05"),
//    U018("Original Request missing during debit/credit - NO", "05"),
//    U019("Maximum Balance exceeds limits set by Beneficiary bank - PS", "05"),
//    U020("Payer Account issue - QU", "05"), U021("PSP not supported - UA", "05"),
//    U022("Unable to process due to internal exception - Beneficiary - UB", "97"), U023("PSP timed out - UP", "97"),
//    U024("Mandate revoked - VA", "05"), U025("Incorrect recurrence pattern - VB", "05"),
//    U026("Incorrect recurrence pattern rule - VC", "05"), U027("Incorrect Amount rule - VD", "05"),
//    U028("OneTime Mandate already honoured - VE", "05"), U029("UMN does not exist - Remitter - VF", "05"),
//    U030("Payer VPA Incorrect - Remitter - VG", "05"),
//    U031("Suspect Fraud based on Mandate Signature tampered/corrupt by Remitter - VH", "05"),
//    U032("Remitter Execution day and rule mismatch - VI", "05"), U033("Payer Account issue - Remitter - VJ", "05"),
//    U034("Exceeds number of allowed mandates on the account at Issuer bank - VK", "05"),
//    U035("Mandate Registration not allowed for given account  - VL", "05"),
//    U036("Nature of Debit not allowed for given account - VM", "05"),
//    U037("Payment stopped - court order - VO", "05"), U038("Withdrawal stopped - account holder demise - VP", "05"),
//    U039("Withdrawal stopped - account insolvency - VQ", "05"),
//    U040("Withdrawal stopped - account holder lunacy - VR", "05"), U041("Duplicate Mandate - VS", "05"),
//    U042("Mandate Paused - VT", "05"), U043("Mandate Expired - VU", "05"), U044("Payee VPA Incorrect - VY", "05"),
//    U045("Payment stopped - attachment order - VZ", "05"), U046("Invalid Merchat at Acquirer - X6", "05"),
//    U047("Merchant unreachable at Acquirer - X7", "05"), U048("Invalid Transaction - Remitter - XB", "05"),
//    U049("Invalid Transaction - Beneficiary - XC", "05"), U050("Invalid Amount - Remitter - XD", "05"),
//    U051("Invalid Amount - Beneficiary - XE", "05"), U052("Format Error - Remitter - XF", "05"),
//    U053("Format Error - Beneficiary - XG", "05"), U054("Account does not exist - Remitter - XH", "05"),
//    U055("Account does not exist - Beneficiary - XI", "05"),
//    U056("Requested Function not supported - Remitter - XJ", "05"),
//    U057("Requested Function not supported - Beneficiary - XK", "05"), U058("Expired card - Remitter - XL", "05"),
//    U059("Expired card - Beneficiary - XM", "05"), U060("No card record - Remitter - XN", "05"),
//    U061("No card record - Beneficiary - XO", "05"),
//    U062("Transaction not permitted to cardholder - Remitter - XP", "05"),
//    U063("Transaction not permitted to cardholder - Beneficiary - XQ", "05"),
//    U064("Restricted card - Remitter - XR", "05"), U065("Restricted card - Beneficiary - XS", "05"),
//    U066("CutOff in process - Remitter - XT", "05"), U067("CutOff in process - Beneficiary - XU", "05"),
//    U068("Compliance violation - Remitter - XV", "05"), U069("Compliance violation - Beneficiary - XW", "05"),
//    U070("No Financial Address found - XX", "05"), U071("CBS Offline - Remitter - XY", "05"),
//    U072("CBS Offline - Beneficiary - XZ", "05"), U073("Lost or Stolen card - Remitter - YA", "05"),
//    U074("Lost or Stolen card - Beneficiary - YB", "05"), U075("Do not honour - Remitter - YC", "05"),
//    U076("Do not honour - Beneficiary - YD", "05"), U077("Account blocked or frozen - Remitter - YE", "05"),
//    U078("Account blocked or frozen - Beneficiary - YF", "05"), U079("Merchant error - Acquirer  - YH", "05"),
//    U080("Invalid Response code - YI", "05"), U081("Invalid Beneficiary credentials - Z5", "05"),
//    U082("Number of PIN tries exceeded - Z6", "05"), U083("Transaction frequency exceeds - Remitter - Z7", "05"),
//    U084("Transaction limit exceeds - Remitter - Z8", "05"), U085("Insufficient funds - Remitter - Z9", "05"),
//    U086("Beneficiary Acquirer Unavailable - ZC", "05"), U087("Validation Error - ZD", "05"),
//    U088("Transaction not Permitted to device - ZF", "05"),
//    U089("Suspect fraud based on Risk Score by Beneficiary - ZI", "05"),
//    U090("Node Offline - Beneficiary/Acquiring switch inoperative - ZJ", "05"),
//    U091("Node Offline - Remitter/Issuer switch inoperative - ZK", "05"), U092("Received late response - ZL", "05"),
//    U093("Invalid MPIN - ZM", "05"),
//    U094("Functionality not yet available for merchant - Acquiring Bank - ZN", "05"),
//    U095("Functionality not yet available for customer - Payee PSP - ZO", "05"),
//    U096("Bank as beneficiary not live for given trasnaction type - ZP", "05"),
//    U097("Unable to process Reversal - ZQ", "05"), U098("Invalid / Incorrect OTP - ZR", "05"),
//    U099("Expired OTP - ZS", "05"), U100("OTP transaction limits exceeded - ZT", "05"),
//    U101("Limit exceeded - Remitter bank - ZU", "05"), U102("Invalid OTP - ZV", "05"),
//    U103("Account Inactive/ Dormant - Remitter - ZX", "05"),
//    U104("Account Inactive/ Dormant - Beneficiary - ZY", "05"), U105("Mandate Paused by User - QA", "05"),
//    U106("Mandate already honoured - QB", "05"), U107("Mandate revoked - QC", "05"),
//    U108("Mandate expired - QD", "05"), U109("Mandate Amount differs from Txn Amount - QH", "05"),
//    U110("Payee VPA Incorrect - Payer - QI", "05"), U111("Mandate request limit breached - QK", "05"),
//    U112("Mandate Debit beyond PSP Amount cap - QL", "05"),
//    U113("Mandate Execution day and rule mismatch - Payer - QR", "05"),
//    U114("Payer Profile does not exist - Deregistered or VPA removed/changed - QS", "05"),
//    U115("Payer Account changed - Payer - QU", "05"), U116("Payer and Payee Accounts cannot be same - RA", "05"),
//    U117("Spam - Collect request declined by PSP - S0", "05"),
//    U118("Payee reported as SPAM under Rule 1 - S1", "05"), U119("Payee reported as SPAM under Rule 2 - S2", "05"),
//    U120("Payee reported as SPAM under Rule 3 - S3", "05"),
//    U121("Transaction not permitted for Over-Draft accounts - SA", "05"),
//    U122("Collect Request declined as Requestor is blocked by customer - TM", "05"), U123("Expired VPA - UX", "05"),
//    U124("Mandate Declined - Payee is not a merchant  - VX", "05"),
//    U125("Response not received within TAT as set by Payee - X1", "05"),
//    U126("Merchant Error - Payee PSP - YG", "05"), U127("Transaction Declined by Customer - ZA", "05"),
//    U128("Invalid Merchat - Payee PSP - ZB", "05"), U129("Transaction not permitted to VPA - PSP - ZE", "05"),
//    U130("VPA restricted by Customer - ZG", "05"), U131("Invalid VPA - ZH", "05"),
//    U132("Card not active - AJ", "05"), U133("MPIN not set by Customer - AM", "05"),
//    U134("Account linked with multiple names - Transaction not permitted to the account - B2", "05"),
//    U135("Bank Card Management system down - B7", "05"),
//    U136("Mobile number registered with multiple Customer ID - BR", "05"),
//    U137("Bank HSM down - Beneficiary - HS", "05"),
//    U138("Unable to process due to internal exception - Remitter - IR", "05"),
//    U139("Unable to process credit from Bank Pool  - LC", "05"),
//    U140("Unable to process debit to Bank Pool - LD", "05"), U141("Invalid MPIN - RM", "05"),
//    U142("Registration Blocked temporarily due to number of attempts exceeded - RN", "05"),
//    U143("Account already registered with MBEBA flag as Y - RZ", "05"),
//    U144("Invalid / Incorrect ATM PIN - SP", "05"), U145("VAE exist - VE", "05"),
//    U146("VAE does not exist - VN", "05"), U147("Account does not exist - XH", "05"),
//    U148("Expired card - XL", "05"), U149("No card record found - XN", "05"), U150("Restricted card - XR", "05"),
//    U151("Number of PIN tries exceeded - Z6", "05"), U152("Invalid /Incorrect MPIN - ZM", "05"),
//    U153("Invalid /Incorrect OTP - ZR", "05"), U154("OTP time expired - ZS", "97"),
//    U155("Number of OTP tries exceeded - ZT", "05"), U156("Duplicate Block Fund for Mandate request - IA", "05"),
//    U157("Mandate request is declined by Merchant (Payee) - MM", "05"), U158("Mandate revoked - QC", "05"),
//    U159("Mandate expired - QD", "05"), U160("UMN does not exist - Payer - QJ", "05"),
//    U161("Payer VPA Incorrect - Payer - QM", "05"), U162("Duplicate Mandate - QN", "05"),
//    U163("This Mandate is non revokable - QO", "05"),
//    U164("Payer initiated mandate cannot be modified by Payee - QP", "05"),
//    U165("Mandate cannot be created in this VPA - Payer - QQ", "05"),
//    U166("Mandate modify request is declined - Payer - QT", "05"),
//    U167("Mandate declined because Payee is not a merchant - Payer - QV", "05"),
//    U168("UMN does not exist - Payee - QW", "05"), U169("Payer VPA Incorrect - Payee - QX", "05"),
//    U170("Payee initiated mandate cannot be modified by Payer - QY", "05"),
//    U171("Mandate modify request is declined by Merchant - QZ", "05"),
//    U172("Mandate cannot be created in this VPA - Payee - VV", "05"),
//    U173("Mandate modify request is declined - Payee - VW", "05"),
//    U174("Revoke Mandate after the remitter unblocked the Amount - IB", "05"),
//    U175("UMN does not exist - Payer - QJ", "05"), U176("Duplicate Mandate - QN", "05"),
//    U177("UMN does not exist - Remitter - VF", "05"), U178("Payer VPA Incorrect - Remitter - VG", "05"),
//    U179("Mandate Registration not allowed for given account  - VL", "05"),
//    U180("Nature of Debit not allowed for given account - VM", "05"), U181("Mandate Expired - VU", "05"),
//    U182("Duplicate Request - U01", "05"), U183("Amount CAP exceeded - U02", "05"),
//    U184("Net Debit CAP exceeded - U03", "05"), U185("Request not found - U04", "05"),
//    U186("Format error - U05", "05"), U187("Transaction ID Is Mismatched - U06", "05"),
//    U188("Validation Error - U07", "05"), U189("System Exception - U08", "05"),
//    U190("REQAUTH Time Out For Pay - U09", "97"), U191("Illegal Operation - U10", "05"),
//    U192("Credentials Is Not Present - U11", "05"), U193("Amount Or Currency Mismatch - U12", "05"),
//    U194("External Error - U13", "05"), U195("Encryption Error - U14", "05"), U196("Checksum Failed - U15", "05"),
//    U197("Risk Threshold Exceeded - U16", "05"), U198("PSP Is Not Registered - U17", "05"),
//    U199("Request Authorisation Acknowledgement Is Not Received - U18", "05"),
//    U200("Request Authorisation Is Declined - U19", "05"), U201("Request Authorisation Timeout - U20", "97"),
//    U202("Request Authorisation Is Not Found - U21", "05"), U203("CM Request Is Declined - U22", "05"),
//    U204("CM Request Timeout - U23", "97"), U205("CM Request Acknowledgement Is Not Received - U24", "05"),
//    U206("CM Url Is Not Found - U25", "05"),
//    U207("PSP Request Credit Pay Acknowledgement Is Not Received - U26", "05"),
//    U208("No Response From PSP - U27", "05"), U209("PSP Not Available - U28", "05"),
//    U210("Address Resolution Is Failed - U29", "05"), U211("Debit Has Been Failed - U30", "05"),
//    U212("Credit Has Been Failed - U31", "05"), U213("Credit Revert Has Been Failed - U32", "05"),
//    U214("Debit Revert Has Been Failed - U33", "05"), U215("Reverted - U34", "05"),
//    U216("Response Is Already Been Received - U35", "05"), U217("Request Is Already Been Sent - U36", "05"),
//    U218("Reversal Has Been Sent - U37", "05"), U219("Response Is Already Been Sent - U38", "05"),
//    U220("Transaction Is Already Been Failed - U39", "05"), U221("IMPS Processing Failed In UPI - U40", "05"),
//    U222("IMPS Is Signed Off - U41", "05"), U223("IMPS Transaction Is Already Been Processed - U42", "05"),
//    U224("IMPS Is Declined - U43", "05"), U225("Form Has Been Signed Off - U44", "05"),
//    U226("Form Processing Has Been Failed In UPI - U45", "05"), U227("Request Credit Is Not Found - U46", "05"),
//    U228("Request Debit Is Not Found - U47", "05"), U229("Transaction ID Is Not Present - U48", "05"),
//    U230("Request Message ID Is Not Present - U49", "05"), U231("IFSC Is Not Present - U50", "05"),
//    U232("Request Refund Is Not Found - U51", "05"), U233("PSP OrgID Not Found - U52", "05"),
//    U234("PSP Request Pay Debit Acknowledgement Not Received - U53", "05"),
//    U235("Transaction ID Or Amount In Credential Block Does Not Match With That In Reqpay - U54", "05"),
//    U236("Message Integrity Failed Due To OrgID Mismatch - U55", "05"),
//    U237("Number Of Payees Differs From Original Request - U56", "05"),
//    U238("Payee Amount Differs From Original Request - U57", "05"),
//    U239("Payer Amount Differs From Original Request - U58", "05"),
//    U240("Payee Address Differs From Original Request - U59", "05"),
//    U241("Payer Address Differs From Original Request - U60", "05"),
//    U242("Payee Info Differs From Original Request - U61", "05"),
//    U243("Payer Info Differs From Original Request - U62", "05"),
//    U244("Device Registration Failed In UPI - U63", "05"),
//    U245("Data Tag Should Contain 4 Parts During Device Registration - U64", "05"),
//    U246("Creds Block Should Contain Correct Elements During Device Registration - U65", "05"),
//    U247("Device Fingerprint Mismatch - U66", "05"), U248("Debit Timeout - U67", "97"),
//    U249("Credit Timeout - U68", "97"), U250("Collect Expired - U69", "05"),
//    U251("Received Late Response - U70", "05"), U252("Merchant Credit Not Supported In IMPS - U71", "05"),
//    U253("VAE Failed - U72", "05"), U254("Payer Account Mismatch - U74", "05"),
//    U255("Payee Account Mismatch - U75", "05"),
//    U256("Mobile Banking Registration Format Not Supported By The Issuer Bank - U76", "05"),
//    U257("Merchant Blocked - U77", "05"), U258("Beneficiary Bank Offline - U78", "05"),
//    U259("Read Timeout In Reqpay Credit - U82", "97"), U260("Connection Timeout In Reqpay Debit - U85", "97"),
//    U261("Read Timeout In Reqpay Debit - U87", "97"), U262("Connection Timeout In Reqpay Credit - U88", "97"),
//    U263("Payee VPA Aadhaar Or Iin VPA Is Disabled - U95", "05"),
//    U264("Payer And Payee IFSC/ACNUM Cant Be Same - U96", "05"),
//    U265("PSP Request Meta Acknowledgement Not Received - U97", "05"),
//    U266("Null Ack Received By UPI For Meta Transaction - U98", "05"),
//    U267("Negative Ack Received By UPI For Meta Transaction - U99", "05"),
//    U268("FIRST TRANSACTION LIMIT EXCEEDED - FL", "05"), U269("FREEZE PERIOD FOR FIRST TIME USER - FP", "05"),
//    U270("Service disable on UPI/ Customer is not active - SD", "05"),
//    U271("Country/ Currency not supported - CN", "05"), U272("Invalid verification token - IV", "05"),
//    U273("Payment validity expired - PE", "05"), U274("Request Decline by the bank - RD", "05"),
//    U275("International Service not activated/disabled - IN", "05"),
//    U276("NO ACTION TAKEN (FULL REVERSAL) - 21", "05"), U277("PARTIAL REVERSAL - 32", "05"),
//    U278("ACQUIRER/BENEFICIARY UNAVAILABLE(TIMEOUT) - BT", "05"),
//    U279("CREDIT REVERSAL TIMEOUT(REVERSAL) - RB", "05"), U280("PARTIAL DEBIT REVERSAL TIMEOUT - RP", "05"),
//    U281("DEBIT REVERSAL TIMEOUT(REVERSAL) - RR", "05"), U282("REMITTER/ISSUER UNAVAILABLE (TIMEOUT) - UT", "05"),
//    U283("UIDAI FAILURE - U79", "05"), U284("PSP/BANK IS NON RESPONSIVE - U80", "05"),
//    U285("REMITTER BANK DEEMED CHECK DECLINE/ UIDAI AUTH RES INVALID/FORMAT ERROR - U81", "05"),
//    U286("BENEFICIARY BANK DEEMED CHECK DECLINE - U84", "05"), U287("REMITTER BANK THROTTLING DECLINE - U86", "05"),
//    U288("BENEFICIARY BANK THROTTLING DECLINE - U89", "05"),
//    U289("REMITTER BANK DEEMED HIGH RESPONSE TIME CHECK DECLINE - U90", "05"),
//    U290("BENEFICIARY BANK DEEMED HIGH RESPONSE TIME CHECK DECLINE - U91", "05");
//
//    private String description;
//    private String responseCode;
//
//    private AuthErrorCodeEnum(String description, String responseCode) {
//        this.description = description;
//        this.responseCode = responseCode;
//    }
//
//    public String getDescription() {
//        if (this.description == null) {
//            return "";
//        }
//        return this.description;
//    }
//
//    public String getResponseCode() {
//        if (this.responseCode == null) {
//            return "30";
//        }
//        return this.responseCode;
//    }
//}
//
//public enum ModelEnum {
//
//    ACQUIRER("Acquirer", false, true, true, false, false, true),
//    ADD_SECONDARY_OWNER("Update Other Owner", true, false, false, false, false, false),
//    ADDITIONALTERMINAL("Additional Owner", true, false, false, false, false, false),
//    AGENT("Agent", false, false, false, false, false, true),
//    ALLIANCE_ORG("Alliance Org", true, true, true, false, false, true),
//    ALLIANCE_USER_GROUP("Alliance User Group", true, true, false, false, false, false),
//    ALLIANCEUSER("Alliance User", true, true, false, false, false, false),
//    AMEX("Amex", false, false, true, false, false, false),
//    APPLDUPLICATECHECK("Application Dup Check", true, false, false, false, false, false),
//    APPLICATIONLEAD("Application Lead", true, false, false, false, true, false),
//    BANKTERMINATEDMERCHANTS("Scheme Terminated Merchants", true, false, false, false, false, false),
//    BANK_PROVIDER("Bank Provider Table", false, true, true, false, false, false),
//    BATCH_FILE_DETAILS("Batch File Details", true, false, true, false, false, false),
//    BILL_PAY_MASTER("Utility Bill Pay Master", true, false, true, false, false, false),
//    Beneficiary_MainV2("BeneficiaryMainV2", true, false, true, false, false, false),
//    BIN("Bin Table", false, false, true, false, false, true),
//    BLACKLISTED_PINCODE("Blackelisted pincode", true, false, false, false, false, false),
//    BUSINESS_PLACE_PGRESPONSE("Business Place PG Response", true, false, false, false, false, false),
//    BUSINESS_PLACE_POSRESPONSE("Business Place POS Response", true, false, false, false, false, false),
//    BUSINESSPLACEPGREQUEST("Business Place PG Request", true, false, false, false, false, false),
//    BUSINESSPLACEPOSREQUEST("Business Place POS Request", true, false, false, false, false, false),
//    BATCHREJECTRECORDS("Rejects", true, false, false, false, false, false),
//    CHAIN_SR_ADD_CHAIN("Chain SR Add Chain", true, false, false, false, false, false),
//    CHAIN_SR_AUTH_BLOCK("Chain Sr Auth Block", true, false, false, false, false, false),
//    CHAIN_SR_CONTACT_UPDATE("Chain SR Contact Update", true, false, false, false, false, false),
//    CHAIN_SR_DEFAULT_MERCHANT("Chain SR Default Merchant", true, false, false, false, false, false),
//    CHAIN_SR_PAYMENT_ACCOUNT("Chain SR Payment Account", true, false, false, false, false, false),
//    CHAIN_SR_PAYMENT_OPTION("Chain SR Payment Option", true, false, false, false, false, false),
//    CHAIN_SR_STATEMENT_OPTION("Chain SR Statement Option", true, false, false, false, false, false),
//    CHANGE_OWNERSHIP("Chain Ownership", true, false, false, false, false, false),
//    CHARGEBACK("Chargeback", true, false, false, false, false, false),
//    CHATIDUSERXREF("Chat ID vs External User", true, false, false, false, false, false),
//    CHECKERGROUP("Maker Checker Config", true, true, false, false, false, true),
//    CHINAUNIONPAY("China Union Pay", false, false, false, false, false, false),
//    CIBILMERCHANT("CIBIL Merchant", true, false, false, false, false, false),
//    CLEARING_WAREHOUSE("Clearing Warehouse", true, false, false, false, true, false),
//    COMMUNICATION("Communication", true, true, false, false, false, false),
//    COMMUNICATION_CHANNEL("Comm Channel", true, false, false, false, false, false),
//    COMMUNICATIONLOG("Communication Log", true, false, false, false, false, false),
//    COMMUNICATIONTEMPLATE("Comms Template", true, true, false, false, false, false),
//    CONSUMER_OFFERS("Consumer Offers", true, true, false, false, false, false),
//    CONTACTDETAILUPDATE("Coontact Details Update", true, false, false, false, false, false),
//    COUNTERFEITBIN("Counterfeit BIN", true, true, false, false, false, true),
//    CREDIT_BUREAU_RESPONSE("Credit Bureau Response", true, false, false, false, false, false),
//    CREDITBUREAUREQUEST("Credit Bureau Request", true, false, false, false, false, false),
//    CROSSREFERENCE("Cross Reference ", true, false, false, false, false, false),
//    COMMON_CROSS_REFERENCE("Common Cross Reference ", false, false, false, false, false, false),
//    CURRENCY_CHANGE("Currency Change", false, false, true, false, false, false),
//    CURRENCYEXCHANGERATES("Currency Exchange Rates", false, true, true, false, false, true),
//    CUSTOMER_APPLICATION("Customer Application", true, false, false, true, false, false),
//
//    DATA_DOWNLOAD("Data Download", true, false, false, false, false, false),
//    DATA_DOWNLOAD_CONFIGURATION("Data Download Configuration", true, false, false, false, false, false),
//    DEDUPMERCHANTAPPLICATIONS("De-Duplicate Merchant Applications", true, false, false, false, false, false),
//    DINER("DIner", false, false, true, false, false, false),
//    DISCOVER("Discover", false, false, true, false, false, false),
//    DISPUTES("Disputes", true, false, false, true, false, false),
//    DUPLICATEPAYADVICE("Duplicate Pay Advice", true, false, false, false, false, false),
//    DUPLICATESTATEMENT("Duplicate Statement", true, false, false, false, false, false),
//    EXPIRED_LOGIN_TOKEN("Login Token Which are Expired", false, false, true, false, false, false),
//    EXTERNALCONNECTION("External Connection", true, true, true, false, false, false),
//    EXTERNALUSER("Merchant User", true, true, false, false, false, false),
//    FEE("Fee Table", true, true, false, false, false, true),
//    FRAUDANDRISK("Fraud and Risk", true, true, false, false, false, true),
//    FRAUDDATA("Fraud Data", true, false, false, false, false, false),
//    FILEUPLOADCONFIGURATION("File Upload Configuration", true, false, false, false, false, false),
//    FILEUPLOADREQUEST("File Upload Request", true, false, false, false, false, false),
//    GENERALCONFIGURATION("General Configuration", false, true, true, false, false, true),
//    GLMASTER("General Ledger Master", true, true, false, false, false, true),
//    HELPARTICLE("Help Article", false, true, true, false, false, false),
//    HELPARTICLEKSEQ("Help Article Key Sequence", false, true, true, false, false, false),
//    HELPFIELD("Help Field Description", false, true, true, false, false, false),
//    HELPFIELDKSEQ("Help Field Description Jey Sequence", false, true, true, false, false, false),
//    IGNORE_FIELD_CLASS("IgnoreFieldClass", false, true, false, false, false, false),
//    INTERNET_PAYMENT_GATEWAY("Internet Payment Gateway", true, false, false, false, false, false),
//    INCOMING_EMAIL("Incoming Email ", false, false, true, false, false, false),
//    JOBRUNINFO("Job Run Information", false, false, true, false, false, false),
//    KYC("KYC", true, false, false, false, false, false),
//    LEDGERACCOUNT("Leader", true, false, false, false, false, false),
//    MAINTANENCE_DATA("Maintanence Log", true, false, true, false, false, false),
//    MAKERCHECKERSTORE("Maker Checker Queue", true, false, false, false, false, false),
//    MASTER("MasterCard Controls", false, false, true, false, false, false),
//    MERCHANT_ALL_PAYMENTS("Merchant All Payments", true, false, false, true, false, false),
//    MERCHANT_NOTIFICATION("Merchant Notifications", true, false, false, true, false, false),
//    MERCHANT_STAT_PAY_FILES("Merchant Statment payment files", true, false, false, false, false, false),
//    MERCHANT_TL("Merchant transaction Ledger", true, false, false, true, false, false),
//    MERCHANTAPPLICATION("Application", true, false, false, false, true, false),
//    MERCHANTCATEGORYCODE("Merchant Category Code", false, false, true, false, false, true),
//    MERCHANTCHAIN("Merchant Chain", true, false, false, true, false, false),
//    MERCHANTDEINSTALLATION("Merchant De-Installation", true, false, false, false, false, false),
//    MERCHANTDEMOGRAPHICS("Demographics Data", true, false, false, true, false, false),
//    MERCHANTDOMAIN("Merchant", true, false, false, true, false, false),
//    MERCHANTPAYMENT("Merchant Payments", true, false, false, true, false, false),
//    MERCHANTPAYMENTREQUEST("Payment Request", true, false, false, true, false, false),
//    MERCHANTPAYMENTRESPONSE("Payment Response", true, false, false, true, false, false),
//    MERCHANTPROFILING("Merchant Profile", true, true, false, false, false, true),
//    MERCHANTREJECT("Rejects", true, false, false, false, false, false),
//    MERCHANTONBOARDING("Merchant Onboarding", true, false, false, false, false, false),
//    NCCC("NCCC", false, true, true, false, false, false),
//    NEWMERCHANT("New Merchant", true, false, false, false, false, false),
//    NUMBERGENERATION("Number Generation", false, true, true, false, false, true),
//    OFFER_WAREHOUSE("Offer Warehouse", true, false, false, false, false, false),
//    OFFERS("Offers for Merchants", true, true, false, false, false, true),
//    ON_DEMAND_CRITERIA("On Demand Criteria", false, true, false, false, false, false),
//    ONBOARDING("ONBOARDING CONTROL", true, true, false, false, false, false),
//    ONB_APPLICATION("Onboarding Application", true, false, false, false, true, false),
//    ONB_WORKFLOW("Onboarding Workflow Control", true, true, false, false, false, false),
//    ONUS("Onus Scheme record", false, true, true, false, false, false),
//    OPERATING_TIMES("Operating Times", true, false, false, false, false, false),
//    OPS_NOTIFICATION("Field Executives Notifications", true, false, false, false, false, false),
//    PAPERROLL("PaperRoll", true, false, false, false, false, false),
//    PARTNERNETWORKAPPDEVICE("Partner Network App Device", false, false, false, false, false, false),
//    PARTNERNETWORKCUSTOMER("Partner Network Customer", false, false, false, false, false, false),
//    PARTNERNETWORKGIDTXN("Partner Network Global ID transaction", false, false, false, false, false, false),
//    PARTNERNETWORKGLOBALID("Partner Network Global ID", false, false, false, false, false, false),
//    PARTNERNETWORKMEMBER("Partner Network Member", false, false, false, false, false, false),
//    PASSWORD_CHANGE("Password Change", true, false, false, false, false, false),
//    PAYMENT_ACCOUNT("Payment Account", true, false, false, false, false, false),
//    PAYMENT_LINK("Payment Link for auth", true, false, true, false, true, false),
//    PAYMENT_OPTION("Payment Option", true, false, false, false, false, false),
//    PAYMENTENQUIRY("Payment Enquiry", true, false, false, false, false, false),
//    PINCODE("Pincode", false, false, true, false, false, true),
//    POSTING_TL_UPD("Txn update for TL", true, false, false, true, true, false),
//    POSTING_TRANSACTION_HOLD("Hold Transactions", true, false, false, true, true, false),
//    PRETOKEN("PreTokenize records", false, false, false, false, false, false),
//    PRICING("Pricing Table", true, true, false, false, false, true),
//    PRIVILEDGE("Priviledge", false, true, true, false, false, false),
//    PRODUCTINVENTORY("Product Inventory", true, true, false, false, false, true),
//    PRODUCTCATALOGUE("Product Catalogue", true, true, false, false, false, true),
//    PROFILE("Profile", true, false, false, false, false, false),
//    PYMT_TRAN("Payment Transaction", true, false, false, true, false, false),
//    REBATE("Rebates", true, true, false, false, false, true),
//    RECONISSUE("Recon Issue", true, false, false, false, false, false),
//    REJECT("Reject", true, false, false, false, true, false),
//    REVERSAL("Reversal Transaction", true, false, false, true, false, false),
//    ROLE("Role", true, true, true, false, false, true), RUPAY("Rupay", false, true, true, false, false, false),
//    SALESDISCUSSION("Sales Discussion", true, false, false, false, false, false),
//    SALESMARKETINGDISCUSSION("Sales Marketing Discussion", true, false, false, false, false, false),
//    SCHEMEDESTINATION("Switch Destination", true, false, false, false, false, true),
//    SERVICE_DIRECTORY("Service Directory", true, false, false, false, false, false),
//    SERVICE_REQUEST("Service Request", true, false, false, false, true, false),
//    SERVICE_REQUEST_CTRL("Service Request Controls", true, true, false, false, false, true),
//    SETTLEMENT("Posted Transaction", true, false, false, true, true, false),
//    SIGNUPVO("SignUp VO", true, false, false, false, false, false),
//    SRADDDISPUTE("SR Add Dispute", true, false, false, false, false, false),
//    SRMERCHAIN("SR Merchant Chain", true, false, false, false, false, false),
//    SRMERCHANTCHAIN("SR Merchant Chain", true, false, false, false, false, false),
//    SRUPDATEDISPUTE("SR Updated Dispute", true, false, false, false, false, false),
//    STATECODES("State Codes", false, false, true, false, false, false),
//    STATEMENT_OPTION("Statement Option", true, false, false, false, false, false),
//    STATISTICS("Statistics", false, false, true, false, false, false),
//    SWITCH("Switch Controls", true, true, true, false, false, true),
//    SWITCHAUTHWAREHOUSE("Switch Auth Warehouse", true, false, false, false, false, false),
//    SWITCHCROSSREFERENCE("Switch Cross Ref", true, false, false, false, false, false),
//    SWITCHHSMKEY("Switch HSM Key", false, true, true, false, false, true),
//    SWITCHPROCESSING("Switch Processing", false, true, true, false, false, true),
//    SYSTEMUSER("System User", true, true, true, false, false, true),
//    SYSTEMUSER_GROUP("Group for system users", true, true, true, false, false, true),
//    TALKRM("Talk to RM", true, false, false, false, false, false),
//    TAX("Tax", true, true, false, false, false, true),
//    TECHNICAL_ISSUE_NOTIFICATION("Technical Issue Notification", false, false, false, false, false, false),
//    TEMPCBSSTORAGE("Temp CBS Storage", true, false, false, false, false, false),
//    TEMPSTORAGE("Termp Storage", false, false, false, false, false, false),
//    TEMPREVERSALSTORAGE("Temp Reversal Storage", true, false, false, false, false, false),
//    TERMINAL("Terminal", true, false, false, true, false, false),
//    TERMINAL_AUTH_LOG("Authorization Log", true, false, false, true, false, false),
//    TERMINAL_AUTH_TRACKER("Authorization Tracker", true, false, false, true, false, false),
//    TERMINALBREAKDOWN("Terminal Breakdown", true, false, false, false, false, false),
//    TERMINALDEINSTALLATION("Terminal De-Installation", true, false, false, false, false, false),
//    TOKEN("Sensity Data Encryption", false, false, false, false, false, false),
//    TOKEN_KEY("Sensity Data Encryption Key", false, false, false, false, false, false),
//    TRACE_REQUEST_RESPONSE("Trace Request Response Data", true, false, true, false, false, false),
//    TRACESTATUPDATE("TRACE Stat Update", false, false, false, false, false, false),
//    TRANSACTIONALCONTROL("Transactional Control", true, true, false, false, false, false),
//    TRANSACTIONLEDGER("Transaction Ledger", true, true, false, false, false, true),
//    TRANSIT_CARD("Transit Card", false, true, false, false, false, false),
//    TRANSIT_CARDTYPE("Transit Card Type", false, true, false, false, false, false),
//    TRANSIT_ROUTE("Transit Route", false, true, false, false, false, false),
//    TRANSIT_TRIP_HISTORY("Transit Trip History", false, true, false, false, false, false),
//    TXN_POSTING_WAREHOUSE("Txn Posting Warehouse", true, false, false, false, false, false),
//    UPI("UPI Control", false, true, true, false, false, false),
//    VISA("Visa Control", false, true, true, false, false, false),
//    MC_CARD_PRODUCT_ID("Mc CardProductId Control", false, true, true, false, false, false),
//    CLEARING_REASON_CODES("Clearing Reasons Codes", false, true, true, false, false, false),
//    AUTH_TRANSCATION_FLOW_LOGS("auth transcation logs", false, true, true, false, false, false),
//    SMS("Sms Table", true, true, false, false, false, false),
//    DISPUTE_MANAGEMENT("Disputes", true, false, false, false, true, true),
//    // ISSUING
//    CUSTOMER_ACCOUNT("Prepaid Wallet", true, false, false, true, false, false),
//    CUSTOMER_PROFILE("Customer Record ", true, false, false, true, false, false),
//    PRODUCT_PROFILE("Payment Instrument Profile", true, false, false, false, false, true),
//
//    ;
//
//    private String description;
//    private boolean allianceLevelControl;
//    private boolean isControl;
//    private boolean allowedForAdminAtToucan;
//    private boolean isClusterActive;
//    private boolean isArchiveActive;
//    private boolean isMakerChecker;
//
//    private ModelEnum(String description, boolean allianceLevelControl, boolean isControl,
//                      boolean allowedForAdminAtToucan, boolean isClusterActive, boolean isArchiveActive,
//                      boolean isMakerChecker) {
//        this.description = description;
//        this.allianceLevelControl = allianceLevelControl;
//        this.isControl = isControl;
//        this.allowedForAdminAtToucan = allowedForAdminAtToucan;
//        this.isClusterActive = isClusterActive;
//        this.isArchiveActive = isArchiveActive;
//        this.isMakerChecker = isMakerChecker;
//    }
//
//    public String getDescription() {
//        if (this.description == null) {
//            return "";
//        }
//        return this.description;
//    }
//
//    public boolean isAllianceLevel() {
//        return this.allianceLevelControl;
//    }
//
//    public boolean isControlData() {
//        return this.isControl;
//    }
//
//    public boolean updateAllowedForAdminAtToucan() {
//        return this.allowedForAdminAtToucan;
//    }
//
//    public boolean getIsClusterActive() {
//        return this.isClusterActive;
//    }
//
//    public boolean getIsArchiveActive() {
//        return this.isArchiveActive;
//    }
//
//    public boolean isMakerCheckerActive() {
//        return this.isMakerChecker;
//    }
//}
//
//public enum SearchTypeEnum {
//    GENERAL, NAME, CITY, HOMEPAGE, EMAIL, PHONE, RELATIONSHIP, ADDRESS, CAT1, CAT2, CAT3, CAT4, CAT5, UNIQUE_CODE,
//    COMMUNICATION, DESCRIPTION, IDENTIFICATION, LASTNAME, MOBILE, WORKFLOW_STATUS, VESSEL_NAME, IMO, AGENT_NAME,
//    PRIORITY, STATUS, VALUE1, VALUE2, VALUE3, VALUE4, VALUE5, BIN_ID, PINCODE, MCC, TRANSACTIONALCONTROL,
//    MERCHANTPROFILING, GLMASTER, FRAUDANDRISK, TAX, FEE, REBATE, SWITCH, MERCHANTCHAIN, PRODUCTINVENTORY, PRICING,
//    MERCHANTMASTER, CURRENCYEXCHANGERATES, CUSTOMERCASE, SETTLEMENT, ALLIANCEUSER, COMMUNICATIONTEMPLATE,
//    MERCHANTAPPLICATION, MERCHANTREJECT, MERCHANTPAYMENT, MERCHANTPAYMENTRESPONSE, REJECT, BANKTERMINATEDMERCHANTS,
//    MERCHANTDEMOGRAPHICS, MERCHANTDOMAIN, TRANSACTIONLEDGER, TERMINAL, SWITCHCROSSREFERENCE, CONSUMABLES,
//    TERMINALBREAKDOWN, DUPLICATESTATEMENT, PAYMENTINQUIRY, CONTACTDETAILUPDATE, ADDITIONALTERMINAL,
//    TERMINALDEINSTALLATION, NEWMERCHANT, DUPLICATEPAYADVICE, RECONISSUE, CHARGEBACKINQUIRY, TALKRM,
//    MERCHANTDEINSTALLATION, SRMERCHAIN, STATEMENT_OPTION, INTERNET_PAYMENT_GATEWAY, ADD_SECONDARY_OWNER,
//    CURRENCY_CHANGE, PASSWORD_CHANGE, OPERATING_TIMES, PAYMENT_ACCOUNT, PROFILE, COMMUNICATION_CHANNEL,
//    CHANGE_OWNERSHIP, KYC, FRAUDDATA, LEDGERACCOUNT, CIBILMERCHANT, CROSSREFERENCE, SALESMARKETINGDISCUSSION,
//    SWITCHHSMKEY, COUNTERFEITBIN, POSTING_TRANSACTION_HOLD, MERCHANT_ALL_PAYMENTS, APPLDUPLICATECHECK, DISPUTES,
//    SRMERCHANTCHAIN, SRADDDISPUTE, SRUPDATEDISPUTE, EXTERNALUSER, SYSTEMUSER, BLACKLISTED_PINCODE, MAINTANENCE_DATA,
//    DEDUPMERCHANTAPPLICATIONS, CLEARING_WAREHOUSE, SWITCHAUTHWAREHOUSE, COMMUNICATIONLOG, RETRIEVAL_REQUEST,
//    CHARGEBACK, MERCHANTPAYMENTREQUEST, POSTING_TL_UPD, SYSTEMUSER_GROUP, MERCHANT_NOTIFICATION, OPS_NOTIFICATION,
//    SERVICE_REQUEST, BILL_PAY_MASTER, BATCH_FILE_DETAILS, ON_DEMAND_CRITERIA, TRACE_REQUEST_RESPONSE, PYMT_TRAN,
//    OFFERS, CHAIN_SR_PAYMENT_OPTION, CHAIN_SR_CONTACT_UPDATE, CHAIN_SR_DEFAULT_MERCHANT, CHAIN_SR_AUTH_BLOCK,
//    CHAIN_SR_PAYMENT_ACCOUNT, CHAIN_SR_STATEMENT_OPTION, PAYMENT_OPTION, EXTERNALCONNECTION, CHAIN_SR_ADD_CHAIN,
//    CONSUMER_OFFERS, OFFER_WAREHOUSE, TECHNICAL_ISSUE_NOTIFICATION, ALLIANCE_USER_GROUP, MERCHANT_TL,
//    PRODUCTCATALOGUE, REVERSAL, COMMON_CROSS_REFERENCE, TXN_POSTING_WAREHOUSE, BATCH_REJECT_RECORDS, AUTH_TXN_LOGS,
//    SMS, Beneficiary_MainV2
//}
//
//public enum SearchLikeEnum {
//    TEXT1, TEXT2, TEXT3, TEXT4, TEXT5, TEXT6, TEXT7, TEXT8, TEXT9, TEXT10, TEXT11, TEXT12, TEXT13, TEXT14, TEXT15
//}
//
//public enum CustomerCaseAction {
//    REFER_SM, CALLBACK, APP_SCREEN_REQ_DOC_UPLOAD, APP_SCREEN_DUPLICATE, APP_SCREEN_FRAUD, APP_SCREEN_REJECT,
//    APP_SCREEN_BANK_TERMINATED, APP_SCREEN_WEBPAGE_VALIDATION, APP_SCREEN_UNDERWRITING,
//    APP_SCREEN_CHECK_DOC_EVALUATION, APP_SCREEN_CHECK_BUREAU, APP_SCREEN_BUSINESS_PLACE
//}
//
//public enum CustomerCaseStatus {
//    OPEN, PENDING_ASSIGNMENT, ACKNOWLEDGED, INPROGRESS_WITHREP, PENDING_MERCHANT, SCHEDULED, CLOSE_SUCCESS,
//    CLOSE_FAILURE
//}
//
//public enum ApplicationParameterCheckEnum {
//    Establishment_legal_Name, Establishment_DBA_Name, Establishment_Address, Registered_Address,
//    Establishment_MobileNumber, Establishment_PhoneNumber, Establishment_Email, Establishment_legal_Idproof1_Number,
//    Establishment_legal_Idproof2_Number,
//
//    Owner_LegalName, Owner_DBA_Name, Owner_Curr_Address, Owner_Prev_Address, Owner_MobileNum, Owner_PhoneNum,
//    Owner_Email, Owner_legal_Idproof1, Owner_legal_Idproof2,
//
////		Owner1_LegalName, Owner1_DBA_Name, Owner1_Curr_Address, Owner1_Prev_Address, Owner1_MobileNum, Owner1_PhoneNum,
////		Owner1_Email, Owner1_legal_Idproof1, Owner1_legal_Idproof2,
////
////		Owner1_legalName, Owner2_DBA_Name, Owner2_Curr_Address, Owner2_Prev_Address, Owner2_MobileNum, Owner2_PhoneNum,
////		Owner2_Email, Owner2_legal_Idproof1, Owner2_legal_Idproof2,
//
//    Ip_Address, Establishment_Business_Url, Duplicate_Merchant_Number, Duplicate_Terminal_Number,
//    Duplicate_Consumer_Merchant_Number, Duplicate_Consumer_Terminal_Number,
//
//    RequiredFieldsMissing
//}
//
//public enum CIBILMerchantEnum {
//    APPLICATION_NUMBER, PHONE_NUMBER, EMAIL_ID, ADDRESS, TAX_NUMBER, ACCOUNT_NUMBER
//}
//
//public enum ApplicationStatusEnum {
//    SAVED, SUBMITTED, IN_PROGRESS, BOARDED_SUCCESSFULL, REJECTED, APPROVED, IN_DISCUSSION
//}
//
//public enum ApplicationLeadStatusEnum {
//    IDENTIFIED, ENGAGED, NO_SHOW, INTEND_FOLLOW_UP, QUALIFIED, COLD_CASE, DO_NOT_DISTURB,
//}
//
//public enum OnbLeadCommChannelEnum {
//    PHYSICAL_VISIT, PHONE_CALL, EMAIL, SMS, SOCIAL_MEDIA, OTHER
//}
//
//public enum CommunicationIndicatorEnum {
//    ACQUIRING, ISSUING, BOTH
//}
//
//public enum ApplicationStepNameEnum {
//    GET_GENERATED_APPLICATION_NUMBER(false), REQUIRED_DOC_UPLOAD(true), CHECK_DUPLICATE(true), FRAUD_CHECK(true),
//    REJECT_FILE_CHECK(true), UNDERWRITING(true), CONTACT_POINT_VERIFICATION(true), SCHEME_TERMINATED(true),
//    IF_STP(true), END_STP(true), CHECK_BUREAU(true),
//
//    CHECK_CUSTOM1(true), CHECK_CUSTOM2(true), CHECK_CUSTOM3(true), CHECK_CUSTOM4(true), CHECK_CUSTOM5(true),
//    CHECK_CUSTOM6(true), CHECK_CUSTOM7(true), CHECK_CUSTOM8(true), CHECK_CUSTOM9(true), CHECK_CUSTOM10(true),
//    CHECK_CUSTOM11(true), CHECK_CUSTOM12(true), CHECK_CUSTOM13(true), CHECK_CUSTOM14(true), CHECK_CUSTOM15(true),
//    CHECK_CUSTOM16(true), CHECK_CUSTOM17(true), CHECK_CUSTOM18(true),
//
//    BUSINESS_APPROVAL(true), DOC_VERIFICATION(true), WEBSITE_VERIFICATION(true), CREATE_MERCHANT_MASTER(false),
//    SUCCESSFULLY_BOARDED(false), BLACKLISTED_PINCODE(true), PREAPPROVAL(false), PRICING_APPROVAL(true);// need to be
//    // removed
//    // later
//
//    private Boolean showOnUI;
//
//    public Boolean getShowOnUI() {
//        return showOnUI;
//    }
//
//    public void setShowOnUI(Boolean showOnUI) {
//        this.showOnUI = showOnUI;
//    }
//
//    private ApplicationStepNameEnum(Boolean showOnUI) {
//        this.showOnUI = showOnUI;
//    }
//
//}
//
//public enum ApplicationStepActionEnum {
//    APPROVE, REFER, REJECT, START
//}
//
//public enum BatchRealTimeEnum {
//    BATCH, REALTIME
//}
//
//public enum MessageEnum {
//    SAMPLE_GET_V1, APP_LIST_ALL_V1, APP_CREATE_V1, APP_UPDATE_V1, APP_GET_BY_ID_V1, APP_DEL_BY_ID_V1,
//    APP_ONETIME_V1, APP_DATAENTRY_ONE_V1, APP_DATAENTRY_TWO_V1, APP_DATAENTRY_THREE_V1, APP_ADD_TENDER_LINEITEM_V1,
//    APP_UPDATE_TENDER_LINEITEM_V1, APP_GET_TENDER_SUMMARY_V1, APP_POST_TENDER_SUMMARY_V1, APP_MERCHANTAPP_CRUD,
//    APP_DELETE_TENDER_LINEITEM_V1, APP_TENDER_STATUS_V1, APP_AGENT_CRUD, APP_GENCONFIG_CRUD, APP_ACQUIRER_CRUD,
//    APP_BIN_CRUD, APP_PINCODE_CRUD, APP_HELPER_CRUD, APP_SYSTEMUSER_CRUD, APP_ROLE_CRUD, APP_PRIVILEDGE_CRUD,
//    APP_MCC_CRUD, APP_TRANSACTIONALCONTROL_CRUD, APP_LEDGERACCOUNT_CRUD, APP_COMMUNICATION_CRUD, APP_TAX_CRUD,
//    APP_FEE_CRUD, APP_REBATE_CRUD, APP_MERCHANTPROFILING_CRUD, APP_FRAUDRISK_CRUD, APP_MERCHANTCHAIN_CRUD,
//    APP_SWITCH_CRUD, APP_PRODUCTINVENTORY_CRUD, APP_PRICING_CRUD, APP_EXCHANGERATES_CRUD,
//    APP_COMMUNICATIONTEMPLATE_CRUD, APP_GLMASTER_CRUD, APP_CROSS_REFERENCE_CRUD, APP_MERCHANT_REJECT_CRUD,
//    APP_SETTELMENT_CRUD, APP_APPL_DUPLICATE_CHECK_CRUD, APP_FRAUDDATA_CRUD, APP_BANK_TERMINATED_MERCHANT_CRUD,
//    APP_CIBIL_MERCHANT_CRUD, APP_DSA_USER_CRUD, APP_AMEX_CRUD, APP_DINER_CRUD, APP_DISCOVER_CRUD, APP_UPI_CRUD,
//    APP_RUPAY_CRUD, APP_MASTER_CRUD, APP_VISA_CRUD, APP_CHINA_CRUD, APP_NCCC_CRUD, APP_MERCHANTMASTER_CRUD,
//    APP_MERCHANTDOMAIN_CRUD, APP_MERCHANTDEMOGRAPHICS_CRUD, APP_IDX_CREATE
//}
//
//// public enum StepDescriptionMerchantEnum {
//// CHECKDUPLICATES, FRAUD, PREVIOUSREJECTED, BANKCARDREJECTED, CIBILCHECK,
//// BUSSINESSPLACEVERIFICATION,
//// DOCUMENTVERIFICATION, WEBSITEVERIFICATION, UNDERWRITING,
//// STATETHROUGHPROCESSING, PREAPPROVAL
//// } asked by Sri
//
//public enum ApplicationSourceEnum {
//    DSA, SM, SELF_PORTAL, MERCHANT_APP, BANK_APP, BANK_INTERNAL_APP, BANK_WEB, PARWEB, OPSWEBSL, MERWEB, MERAPP,
//    OPSAPPSR, DEPLETED, OPSWEBSR, PARAPP
//
//}
//
//public enum ApplicationMethodEnum {
//    PAPER, ONLINE, BANK, CALL_CENTRE
//}
//
//public enum MerchantTypeEnum {
//    ONLINE, RETAIL, BOTH
//}
//
//// Change with Open String Field so this need to remove BusinessTypeEnum
////	public enum BusinessTypeEnum {
////		GOVERNMENT, HUF, INDIVIDUAL, PRIVATE, TRUST, PUBLIC, COMPANY, SOCIETY, SOLE_PROPREITOR, PARTNERSHIP, OTHERS,
////		LIMITED_LIABILITY_PARTNERSHIP
////	}
//
//public enum GenderEnum {
//    MALE, FEMALE, OTHER, TRANSGENDER // Need to removed
//}
//
//public enum TransactionModeEnum {
//    AUTHORIZATION, PURCHASE, AUTHORIZATION_AND_PURCHASE
//}
//
//public enum InterfaceLanguageEnum {
//    PHP, JAVA, ASP, ASPX, OTHERS
//}
//
//public enum MerchantWebDevModeEnum {
//    CUSTOMER, THIRD_PARTY, OTHERS
//}
//
//public enum EmailScheduledEnum {
//    WEEKLY, QUARTERLY, MONTHLY,
//}
//
//public enum StatementModeEnum {
//    MAIL, EMAIL, BOTH
//}
//
//public enum StatementFrequencyEnum {
//    MONTHLY, QUARTERLY, HALFYEARLY, YEARLY, NONE
//
//}
//
//public enum SaleTimeFrameEnum {
//    MONTHLY, QUARTERLY, HALFYEARLY, ANNUALLY, FROM_AND_TO
//
//}
//
//public enum StatementPeriodEnum {
//    SIX, TWELVE, THIRTY_SIX
//}
//
//public enum FraudActionEnum {
//    REFER, REJECT
//}
//
//public enum PriviledgeEnum {
//    API, SCREEN_CONTROL, FIELD_CONTROL
//}
//
//public enum OTPEnum {
//    PHONE_NUMBER, EMAIL_ID, APPLICATION_NUMBER, TEMP
//}
//
//public enum TimeFormattedEnum {
//    TIME1("hh:mm:ss"), TIME2("h:m:s"), TIME3("hh:mm");
//
//    private String code;
//
//    private TimeFormattedEnum(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//}
//
//public enum DateFormattedEnum {
//    DATE1("en-IN"), DATE2("en-US"), DATE3("en-GB");
//
//    private String code;
//
//    private DateFormattedEnum(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//}
//
//public enum AmountFormattedEnum {
//    AMOUNT1, AMOUNT2, AMOUNT3
//}
//
//public enum FileCategoryNameEnum {
//    FILE1, FILE2, FILE3
//}
//
//public enum FrequencyBackupEnum {
//    DAILY, MONTHLY, WEEKLY,
//
//}
//
//public enum SMStatusEnum {
//    OPEN, CLOSED, WAITING, DEFERRED, PENDING,
//}
//
//public enum inc_exc_Enum {
//    INCLUDE, EXCLUDE
//}
//
//public enum TxnControlEnum {
//
//    BIOMETRIC_VERIFICATION("bio"), VOID("void"), FEE("fee"), ORIGINAL_CREDIT("origi"), PREAUTH_REQUEST("pre"),
//    BALANCE_ENQUIRY("bal"), LOYALTY_ENQUIRY("loyal"), PURCHASE("01"), PREAUTH_COMPLETION("02"), IVR("03"),
//    ONLINE_REFUND("04"), PURCHASE_CASHBACK("05"), ONOFFTIP("06"), REFUND("07"), LOYALTY_REDEMPTION("08"),
//    CASH_WITHDRAWAL("09"), CASH_DEPOSIT("23"), CASHPOS("10"), STANDINGINSTRUCTION("11"), EMI("12"),
//    DISPUTE_CONFIRMED("13"), DISPUTE_CANCELLED("14"), INITIAL_DISPUTE("15"), DEBITADJUSTMENT("16"),
//    CREDITADJUSTMENT("17"), LATE_SETTLEMENT_FEE("30"), FALLBACK_FEE("31"), UTILITY_FEE("32"), ADMIN_FEE("33"),
//    DUP_PA_FEE("34"), DUP_EMAIL_PA_FEE("35"), DUP_STMT_FEE("36"), DUP_EMAIL_STMT_FEE("37"), USER_FEE("38"),
//    RENT_FEE("39"), PROCESSING_FEE("40"), SUPPLY_FEE("41"), TURNOVER_FEE("42"), CHARGEBACK_FEE("43"),
//    SETUP_FEE("44"), SURCHARGE_FEE("45"), STATEMENT_FEE("46"), MEMBERSHIP_FEE("47"), MISC_FEE("48"),
//    SERVICE_FEE("49"), CONVENIENCE_FEE("50"), DEINSTALLATION_FEE("51"), REPLACEMENT_FEE("52"), TXN_FEE_1("53"),
//    TXN_FEE_2("54"), TXN_FEE_3("55"), R_LATE_SETTLEMENT_FEE("60"), R_FALLBACK_FEE("61"), R_UTILITY_FEE("62"),
//    R_ADMIN_FEE("63"), R_DUP_PA_FEE("64"), R_DUP_EMAIL_PA_FEE("65"), R_DUP_STMT_FEE("66"),
//    R_DUP_EMAIL_STMT_FEE("67"), R_USER_FEE("68"), R_RENT_FEE("69"), R_PROCESSING_FEE("70"), R_SUPPLY_FEE("71"),
//    R_TURNOVER_FEE("72"), R_CHARGEBACK_FEE("73"), R_SETUP_FEE("74"), R_SURCHARGE_FEE("75"), R_STATEMENT_FEE("76"),
//    R_MEMBERSHIP_FEE("77"), R_MISC_FEE("78"), R_SERVICE_FEE("79"), R_CONVENIENCE_FEE("80"),
//    R_DEINSTALLATION_FEE("81"), R_REPLACEMENT_FEE("82"), NSF("83"), R_NSF("84"), R_PURCHASE("85"),
//    R_PAYMENT_ADVICE_FEE("86"), I_BANKING("18"), DCC_SALE("19"), DCC_REFUND("20"), ALL("00"),
//    PAYMENT_ADVICE_FEE("56"), MERCHANT_CREDIT_ADJUSTMENT("21"), MERCHANT_DEBIT_ADJUSTMENT("22"), ADVICE("24"),
//    CREDENTIAL_ON_FILE("25");
//
//    private String code;
//
//    private TxnControlEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//}
//
//// public enum PostingTxnTypeEnum {
//// SALES("10"), REBATE("10"), R_REBATE("10"), REFUND("10"),
//// LATE_SETTLEMENT_FEE("10"), R_LATE_SETTLEMENT_FEE("10"),
//// FALLBACK_FEE("10"), R_FALLBACK_FEE("10"),
//// ADMIN_FEE("10"), R_ADMIN_FEE("10"), PAYMENT_ADVICE_FEE("10"),
//// R_PAYMENT_ADVICE_FEE("10"), RENT_FEE("10"),
//// R_RENT_FEE("10"), SUPPLY_FEE("10"), R_SUPPLY_FEE("10"), TURNOVER_FEE("10"),
//// R_TURNOVER_FEE("10"), CHARGEBACK_FEE("10"),
//// R_CHARGEBACK_FEE("10"), SETUP_FEE("10"), R_SETUP_FEE("10"),
//// SURCHARGE_FEE("10"), R_SURCHARGE_FEE("10"), STATEMENT_FEE("10"),
//// R_STATEMENT_FEE("10"), MEMBERSHIP_FEE("10"), R_MEMBERSHIP_FEE("10"),
//// MISC_FEE("10"),R_MISC_FEE("10"), SERVICE_FEE("10"),
//// R_SERVICE_FEE("10"), CONVENIENCE_FEE("10"), R_CONVENIENCE_FEE("10"),
//// DEINSTALLATION_FEE("10"),R_DEINSTALLATION_FEE("10"),
//// REPLACEMENT_FEE("10"), R_REPLACEMENT_FEE("10"), DEBITADJUSTMENT("10"),
//// CREDITADJUSTMENT("10"), DISPUTE_CONFIRMED("10"),
//// DISPUTE_CANCELLED("10"), INITIAL_DISPUTE("10");
////
//// private String code;
////
//// private PostingTxnTypeEnum(String code) {
//// this.code = code;
////
//// }
////
//// public String getCode() {
//// return this.code;
//// }
//// public void setCode(String code) {
//// this.code = code;
//// }
//// }
//
//public enum PostingRejectEnum {
//    MERCHANT_NOT_FOUND, PROFILE_NOT_FOUND, SETT_RECORD_NULL, INVALD_TRAN_CODE, PRICING_CANNOT_BE_DETERMINED,
//    PRICING_EMPTY, PRICING_LIST_EMPTY, FEE_NOT_FOUND, REJECTED_DUE_TO_TRANSACTION_MTI,
//    REJECTED_DUE_TO_TRANSACTION_MTI_INCLUDE_EXCLUDE, REJECTED_DUE_TO_PINCODE, REJECTED_DUE_TO_CITY,
//    REJECTED_DUE_TO_STATE, REJECTED_DUE_TO_COUNTRY, RANGES_DOESNT_LIES, ORIGINAL_TRAN_NOT_FOUND, ALREADY_REFUNDED,
//    FEE_FOUND_INACTIVE, RISK_PROFILE_NOT_SET, PRICING_TAX_RECORD_NOT_FOUND, RISK_PROFILE_DATA_NOT_FOUND,
//    MERCHANT_INACTIVE, FBACK_FEE_TABLE_NOT_SET
//
//}
//
//public enum PosDataCodeEnum {
//    UNKNOWN("00"), MANUAL("01"), MAGNETIC_STRIPE("02"), ICC("09"), KEY_ENTRY("06"), CONTACT_LESS_MAGNETIC("04"),
//    MAGNETIC_STRIP_READER_KEY_ENTRY("07"), MAGNETIC_STRIP_READER_ICC_ENTRY("08"), MAGNETIC_STRIP_READER_ICC("05"),
//    CONTACT_LESS_CHIP("03"), MERCHANT_INITIATE_TXN_PAN_PRESENT("10"), MAG_STRIPE_READ_FOR_CHIP("80"),
//    MC_PAN_AUTO_ENTRY("82"), CHIP_RADIO_FREQ_ID("83"), TRACK_HALF_INCLUDED_IN_MAG_STRIPE("90"),
//    CONTACTLESS_MAG_STRIPE_ACCT_NBR_AUTO_ENTRY("91"), INTEGRATED_CIRCUIT_CARD("95");
//
//    private String code;
//
//    private PosDataCodeEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//}
//
//public enum PosEntryCodeEnum {
//    NA("000"), ALL("999"), UNKNOWN("00"), MANUAL("001"), MAGNETIC_STRIPE_READ("002"), IVR("006"),
//    CONTACTLESS_PAYMENT_USING_CHIP_CARD("007"), QR_CODE("008"), FALLBACK_TRANSACTIONS("080"), E_COMMERCE("081"),
//    CONTACTLESS_USING_CVD("091"), CONTACT_CHIP("005");
//
//    private String code;
//
//    private PosEntryCodeEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum AvailablePaymentModeEnum {
//    CARDS, NETBANK, UPI_NPCI, WALLETS, EMI;
//}
//
//public enum AvailableCardPaymentSchemeEnum {
//    VISA, MC, RUPAY;
//}
//
//public enum CardPressEnum {
//    NONE("0"), CAPTURE("1"), UNKNOWN("9");
//
//    private String code;
//
//    private CardPressEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum OperatingEnvEnum {
//    NO_TERMINAL_USED("0"), ON_PREMISES_CARDACCEPTOR_ATTENDED("1"), ON_PREMISES_CARDACCEPTOR_UNATTENDED("2"),
//    OFF_PREMISES_CARDACCEPTOR_ATTENDED("3"), OFF_PREMISES_CARDACCEPTOR_UNATTENDED("4"),
//    ON_PREMISES_CARDHOLDER_UNATTENDED("5"), OFF_PREMISES_CARDHOLDER_UNATTENDED("6"), UNKNOWN("9");
//
//    private String code;
//
//    private OperatingEnvEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CardHolderPresentEnum {
//    CARDHOLDER_PRESENT("0"), CARDHOLDER_NOT_PRESENT_UNSPECIFIED("1"), CARDHOLDER_NOT_PRESENT_MAIL("2"),
//    CARDHOLDER_NOT_PRESENT_TELEPHONE("3"), CARDHOLDER_NOT_PRESENT_RECURRING("4"), ELECTRONIC_ORDER("5"),
//    UNKNOWN("9");
//
//    private String code;
//
//    private CardHolderPresentEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CardPresentEnum {
//    CARD_PRESENT("1"), CARD_NOT_PRESENT("0"), UNKNOWN("9");
//
//    private String code;
//
//    private CardPresentEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CardDataInputEnum {
//    MANUAL_NOTERMINAL("1"), UNSPECIFIED_DATAUNAVAILABLE("0"), TRACK_DATA_NOT_REQ("2"), KEY_ENTERED("6"),
//    CONTACTLESS_MAGNETIC_STRIP("A"), TRACK_DATA_CAPTURED_PASSES_UNALTERED("B"), ONLINE_AUTHORIZED_CHIP("C"),
//    ELECTRONIC_COMMERCE("S"), PAN_AUTO_ENTRY_VIA_CONTACTLESS_MCHIP("M");
//
//    private String code;
//
//    private CardDataInputEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CardAuthenticationEnum {
//    UNKNOWN("0"), PIN("1"), MANUAL_SIGNATURE_VERIFICATION("5"), OTP("2"), ECOMMERCE_PIN("3"), ECOMMERCE_OTP("4"),
//    IVR("9");
//
//    private String code;
//
//    private CardAuthenticationEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CardAuthenticationEntityEnum {
//    NOT_AUTH_UNKNOWN("0"), ICC_TERMINAL("1"), AUTH_AGENT("3"), MERCHANT("4"), UNKNOWN("9");
//
//    private String code;
//
//    private CardAuthenticationEntityEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CatLevelIndicatorEnum {
//    L1_AUTO_DISPEN_MACHINE_UNATTENDED("S"), L2_SELF_SERVICE_TERMINAL_UNATTENDED("T"),
//    L3_LIM_AMOUNT_TERMINAL_UNATTENDED("U"), MPOS("9");
//
//    private String code;
//
//    private CatLevelIndicatorEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum ElectronicCommIndicatorEnum {
//    ECOMM_3D("05"), NON_SECURE_DATA_ENCRYP("07"), NON_SECURE_TXN("08"), SECURE_TXN_OTP("15"),
//    SECURE_TXN_OTP_IMAGE("21"), ECOMM_CARD("33"), ECOMM_CARD_PAN("35");
//
//    private String code;
//
//    private ElectronicCommIndicatorEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum SwitchRecordNumberEnum {
//    InstitutionLevel("001"), SchemeLevel("002"), MessageLevel("003"), DataElementLevel("004");
//
//    private String code;
//
//    private SwitchRecordNumberEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum MerchantRejectionSourceEnum {
//    SELF, DSA, SM, DIP, CR
//}
//
//public enum MerchantSegmentEnum {
//    PLATINUM, RETAIL, CORPORATE
//}
//
//public enum OTPObjectEnum {
//    CREATE_MODEL, UPDATE_MODEL, DELETE_MODEL
//}
//
//public enum MerchantPriorityEnum {
//    NON_PREMIER, PREMIER
//}
//
//public enum FeeFrequencyEnum {
//    STATEMENT, ANNIVERSARY, DAILY, ADHOC
//}
//
//public enum FixedPercentageEnum {
//    FIXED, PERCENTAGE
//}
//
//public enum NatureOfBussinessEnum {
//    AgriculturalServices, ContractServices, TaxiCabServices, CourierServices, TravelServices, UtilityServices,
//    RetailOutletServices, DutyFree, ClothingServices, MiscellaneousServices, FoodJoints, BusinessServices,
//    Hospitals, Schools, AIRLINES, CLOTHING, CLOCK, DEPARTMENTAL_STORES, ELECTRONICS, GROCERY, HOSPITALS,
//    TRAVEL_AGENTS, HEALTH_N_BEAUTY, TAXI, PETROL_PUMP, RESTAURANT, TELECOM_HARDWARE, OTHERS, AUTO_RENTAL,
//    BILL_PAYMENT, ECOMMERCE_AGGREGATOR, HOTEL, B2B, MEDICAL_HEALTHCARE, TRANSIT_HEALTHCARE, EDUCATIONAL_SERVICES,
//    ALLOTHERMERCHANTS_RETAILS, RAILROADS_AIRLINES_TRANSPORTATION_TRAVELAGENCIES, HOTELS_AND_MOTELS, VEHICLE_RENTALS,
//    UNIQUE_TRANSACTION_SEMICASH_DISBURSEMENTS, MAILORDERS_TELEPHONEORDER, CASH_DISBURSEMENTS,
//    PAYMENT_SERVICE_PROVIDERS
//}
//
//public enum MerchantStatusEnum {
//    NEW, ACTIVE, INACTIVE, TO_BE_CLOSED, CLOSED, PURGED
//}
//
//public enum TransactionStatisticsEnum {
//    DAILY, WEEKLY, BIWEEKLY, MONTHLY, QUARTERLY, YEARLY
//}
//
//public enum TransactionStatusEnum {
//    REQUEST, VOIDED, REFUNDED, COMPLETED, REVERSED, DECLINED
//}
//
//public enum StatementSenderEnum {
//    FIRST_OWNER, SECOND_OWNER, ESTABLISHMENT, REGISTERED, WAREHOUSE
//}
//
//public enum StatementProgressEnum {
//    HOLD, SEND
//}
//
//public enum StatementTypeEnum {
//    DETAILED, SUMMARY, NONE
//}
//
//public enum MerchantProductEnum {
//    WIRED_POS, WIRELESS_POS, QR_CODE, INSTA_QR_CODE_MID, INTERNET_GATEWAY, MOBILE_POS, PC_POS, BHIM_AADHAR_PAY_OUT,
//    OTHERS
//}
//
//public enum ANDOREnum {
//    AND, OR
//}
//
//public enum OperatorEnum {
//    GT, LT, EQ, GE, LE, NE, LIKE
//}
//
//public enum PaymentFrequency {
//    STATEMENT, REALTIME, TXN_nDAYS
//}
//
//public enum StatementLevelEnum {
//    MERCHANT, TERMINAL, CHAIN, BOTH_MID_TID
//}
//
//public enum PaymentAdviceEnum {
//    MERCHANT, TERMINAL, BOTH_MID_TID, CHAIN, MERCHANT_AND_CHAIN
//}
//
//public enum PaymentProductCodeEnum {
//    IMPS, NEFT, RTGS, DIRECT_CREDIT, DIRECT_DEBIT, CHEQUE, UPI, FT
//}
//
//public enum CheckerEnum {
//    MAKER, CHECKER, BOTH, NONE, DIRECT
//}
//
//public enum MakerCheckerStatusEnum {
//    OPEN, INPROGRESS, SCHEDULED, CLOSE_SUCCESS, REJECTED
//}
//
//public enum MakerCheckerPathEnum {
//    MAKER, CHECKER, NONE
//}
//
//public enum SystemUserAuthMethodEnum {
//    OPENLDAP, INTERNAL
//}
//
//public enum IncomingFileEnum {
//    CARDINTVISA, CARDINTMASTER, CARDINTOTHERS, CARDDOMOFFUSVISA, CARDDOMOFFUSMASTER, CARDDOMOFFUSRUPAY,
//    CARDDOMONUSVISA, CARDDOMONUSMASTER, CARDDOMONUSRUPAY, NETBANKONUS, NETBANKOFFUS, WALLETONUS, WALLETOFFUS,
//    OTHERSONUS, OTHERSOFFUS
//}
//
//public enum EventEnum {
//    // Events tobe removed
//    SERVICE_REQUEST_REJECT("Rejected Service Request", true, SrNotificationVO.class),
//    SERVICE_REQUEST_CREATION("Service Request Created", true, SrNotificationVO.class),
//    SERVICE_REQUEST_CLOSURE("Service Request Closed", true, ServiceRequest.class),
//    MERCHANT_BOARDING_UNSUCCESSFULL("Merchant Onboarding Unsuccessfull", true, SignUpVO.class),
//    TRANSACTION_ALERT("TXN: Alert", false, SignUpVO.class),
//    PASSWORD_CHANGED("Password Changed", false, SignUpVO.class),
//    PASSWORD_CHANGE_CRE("Forgot Password SR create", false, SrNotificationVO.class),
//    PASSWORD_CHANGE_CLOSURE("Forgot Password SR Closure", false, SrNotificationVO.class),
//    QFIX_PTLF_NOT_RECEIVED("PTLF Not Received", true, TechnicalIssueTemplateVO.class), // Need to removed
//
//    // Internal Events
//    CASE_REASSIGNMENT("Case Request Reassigned", true, SignUpVO.class),
//    NEW_IN_WORK_QUEUE("New task in work queue", true, SignUpVO.class),
//    WORK_QUEUE_CLOSED("Work Queue task closed", true, SignUpVO.class),
//    CHECKER_REJECT("Checker rejected update", true, MakerCheckerStore.class),
//    CHECKER_APPROVE("Checker approved update", true, MakerCheckerStore.class),
//    MAKER_SUBMIT("Maker submited request", true, MakerCheckerStore.class),
//    SR_ASSIGN("SR Assign", true, SrInternalCommunicationVO.class),
//    SR_REASSIGN("Sr ReAssign", true, SrInternalCommunicationVO.class),
//    SR_ALERT_NOTIFICATION("SR Alert notification", true, SrInternalCommunicationVO.class),
//    SR_SLA_CROSSED_ALERT("SR Sla cross alert", true, SrInternalCommunicationVO.class),
//    SR_SLA_CROSSED_ESCALATION("SR sla escalation", true, SrInternalCommunicationVO.class),
//    SR_SCHEDULEDATE_ALERT("SR Schedule Date alert", true, SrInternalCommunicationVO.class),
//    BATCH_JOB_SUCCESS("Batch Job Success Report", true, JobRunInfo.class),
//    BATCH_JOB_FAILURE("Batch Job Failure Report", true, JobRunInfo.class),
//    OTP_LOGIN("OTP Send for web login", true, SendOTPVO.class),
//    TOUCAN_REPORT("Batch Job For Toucan Report", true, ToucanDetails.class),
//    SCHEDULER_COMPLETION("Alliance Org Toucan Report", true, ToucanDetails.class),
//    SYSTEM_USER_PASSWORD("System User Password", true, PasswordTemplateVO.class),
//    ALLIANCE_USER_PASSWORD("Alliance user Password", true, PasswordTemplateVO.class),
//    EXTERNAL_USER_PASSWORD("External user Password", true, PasswordTemplateVO.class),
//    EXTERNAL_USER_UPD("External User update", false, SignUpVO.class),
//    ALLIANCE_USER_UPD("Alliance User Update", false, SignUpVO.class),
//    APPLICATION_COVERING_LETTER("Application Covering letter", false, AppCoveringLetterTemplateVO.class),
//    APP_STEP_SLA_CROSSED_ESCALATION("Application Step SLA crossed Escalation", true, AppEscalationVO.class),
//    NEW_MERCHANT_SELF_SERVE_SIGNUP("New Merchant Self SignUp from SR", true, SignUpVO.class),
//    SALES_MANAGER_APPLICATION("Application Sales Manager", true, ManagerDetailsVO.class),
//    SERVICE_MANAGER_MERCHANT("Merchant Service Manager", true, ManagerDetailsVO.class),
//    INTERNAL_FORGOT_PASSWORD("Forgot Password for SystemUser", true, SignUpVO.class),
//    DB_HEALTH_CHECK("DB Health Check", true, DBHealthCheckTemplateVO.class),
//    GREATER_ACQUIRER_REJECT("Greater Acquirer Reject", true, TechnicalIssueTemplateVO.class),
//    GREATER_SCHEME_REJECT("Greater Scheme Reject", true, TechnicalIssueTemplateVO.class),
//    GENERATE_OTP("Pre External User Otp", true, SignUpVO.class),
//    GREATER_ISSUER_REJECT("Greater Issuer Reject", true, TechnicalIssueTemplateVO.class),
//    PAYMENT_TRANSACTION_SUMMARY_EXTRACT_FILE_NOT_FOUND("Payment Transnsaction Summary Extract File Not Found", true,
//            TechnicalIssueTemplateVO.class),
//    PAYMENT_JV_NOT_RECEIVED("Payment JV Not Received", true, TechnicalIssueTemplateVO.class),
//    PTLF_NOT_RECEIVED("PTLF Not Received", true, TechnicalIssueTemplateVO.class),
//    SOCKET_DOWN("Socket Down", true, TechnicalIssueTemplateVO.class),
//    USER_DATA_DOWNLOAD("User Data Download", true, UserDataDownloadVO.class),
//    USER_FILE_UPLOAD_REQUEST("User File Upload Request", true, UserFileUploadRequestVO.class),
//    FORGOT_PASSWORD_PARTNER("Forgot Password for Alliance Partner", true, SignUpVO.class),
//
//    // External Events
//    ONBOARD_OTP_REQ("Applicant Signup OTP", false, SignUpVO.class),
//    MERCHANT_SELF_SERVE_SIGNUP("Applicant Self SignUp", false, SignUpVO.class),
//    MERCHANT_BOARDING_SUCCESSFULL("Merchant Onboarding Successfull", false, SignUpVO.class),
//    MERCHANT_APPLICATION_REJECT("Merchant Application rejected", false, SignUpVO.class),
//    MERCHANT_CREDENTIAL("Merchant credential welcome kit", false, SignUpVO.class),
//
//    FORGOT_PASSWORD("Forgot Password for Merchant, Alliance", false, SignUpVO.class),
//    VERIFY_EMAILID("Verify EmailID", false, SignUpVO.class), SR_OTP("Service Request OTP", false, SignUpVO.class),
//
//    MERCHANT_CREDIT_SUCCESSFULL("Merchant credit successfull", false, PaymentsNotificationVO.class),
//    MERCHANT_CREDIT_UNSUCCESSFULL("Merchant credit unsuccessfull", false, PaymentsNotificationVO.class),
//    MERCHANT_DEBIT_SUCCESSFULL("Merchant debit successfull", false, PaymentsNotificationVO.class),
//    MERCHANT_DEBIT_UNSUCCESSFULL("Merchant debit unsuccessfull", false, PaymentsNotificationVO.class),
//    PREAUTH_PENDING_EXPIRY("Pre-Auth Expiry prior to x days", false, PreAuthNotificationVO.class),
//
//    CONSUMABLES_CRE("Create a Consumables SR", false, SrConsumables.class),
//    CONSUMABLES_CLOSE("Close a Consumables SR", false, SrConsumables.class),
//    CONSUMABLES_APPROVE("Approve a Consumables SR", false, SrNotificationVO.class),
//    CONSUMABLES_REJ("Reject consumables SR", false, SrConsumables.class),
//    CONSUMABLES_REOPEN("Reopen consumables SR", false, SrConsumables.class),
//
//    TERMINALBREAKDOWN_CRE("Create a Terminal Breakdown SR", false, SrTerminalBreakdown.class),
//    TERMINALBREAKDOWN_CLOSE("Close a Terminal Breakdown SR", false, SrTerminalBreakdown.class),
//    TERMINAL_BREAKDOWN_APPROVE("Approve a terminal Breakdonw SR", false, SrTerminalBreakdown.class),
//    TERMINAL_BREAKDOWN_REJ("Reject a Terminal breakdon SR", false, SrTerminalBreakdown.class),
//    TERMINAL_BREAKDOWN_REOPEN("Reopen a Terminal breakdown SR", false, SrTerminalBreakdown.class),
//
//    PAYMENTINQUIRY_CRE("Create a Payment Enquiry", false, SrPaymentEnquiry.class),
//    PAYMENT_INQ_APPROVE("Approve a payment inquiry SR", false, SrPaymentEnquiry.class),
//    PAYMENTINQUIRY_CLOSE("Close a Payment Enquiry", false, SrPaymentEnquiry.class),
//    PAYMENT_INQUIRY_REJ("Reject a payment inquiry SR", false, SrPaymentEnquiry.class),
//    PAYMENT_INQUIRY_REOPEN("Reopen a payment inquiry SR", false, SrPaymentEnquiry.class),
//
//    ADDITIONAL_TERMINALS_CRE("Create Additional Terminal SR", false, SrAdditionalTerminal.class),
//    ADDITIONAL_TERMINALS_APPROVE("Approve Additional terminal SR", false, SrAdditionalTerminal.class),
//    ADDITIONAL_TERMINALS_CLOSE("Close Additional Terminal SR", false, SrAdditionalTerminal.class),
//    ADDITIONAL_TERMINAL_REJ("Reject additional terminal SR", false, SrAdditionalTerminal.class),
//    ADDITIONAL_TERMINAL_REOPEN("Reopen additional terminal SR", false, SrAdditionalTerminal.class),
//
//    ADD_USER_CRE("Create Add user SR", false, SrAddUser.class),
//    ADD_USER_APPROVE("Approve Add user SR", false, SrAddUser.class),
//    ADD_USER_CLOSE("Close Add user SR", false, SrAddUser.class),
//    ADD_USER_REJ("Reject Add user SR", false, SrAddUser.class),
//    ADD_USER_REOPEN("ReOpen Add user SR", false, SrAddUser.class),
//
//    ACTIVEDEACTIVEUSER_CRE("Create Activate/Deactivate user SR", false, SrUpdateExternalUser.class),
//    ACTIVEDEACTIVEUSER_APPROVE("Approve Activate/Deactivate user SR", false, SrUpdateExternalUser.class),
//    ACTIVEDEACTIVEUSER_CLOSE("Close Activate/Deactivate user SR", false, SrUpdateExternalUser.class),
//    ACTIVEDEACTIVEUSER_REJ("Reject Activate/Deactivate user SR", false, SrUpdateExternalUser.class),
//    ACTIVEDEACTIVEUSER_REOPEN("ReOpen Activate/Deactivate user SR", false, SrUpdateExternalUser.class),
//
//    MARKUP_CRE("Create Markup update SR", false, SrMarkupUpdate.class),
//    MARKUP_APPROVE("Approve Markup update SR", false, SrMarkupUpdate.class),
//    MARKUP_CLOSE("Close Markup update SR", false, SrMarkupUpdate.class),
//    MARKUP_REJ("Reject Markup update SR", false, SrMarkupUpdate.class),
//    MARKUP_REOPEN("Reopen a Markup update SR", false, SrMarkupUpdate.class),
//
//    TERMINALDEINSTALLATION_CRE("Create Terminal De-Install SR", false, SrTerminalDeInstallation.class),
//    TERMINALDEINSTALLATION_APPROVE("Approve Terminal De-Install SR", false, SrTerminalDeInstallation.class),
//    TERMINALDEINSTALLATION_CLOSE("Close Terminal Deinstallation SR", false, SrTerminalDeInstallation.class),
//    TERMINAL_DEINSTALLATION_REJ("Reject a Terminal deinstallation SR", false, SrTerminalDeInstallation.class),
//    TERMINAL_DEINSTALLATION_REOPEN("Reopen a Terminal deinstallation SR", false, SrTerminalDeInstallation.class),
//
//    DUPLICATEPAYMENTADVICE_CRE("Create a Duplicate Payment Advice SR", false, SrDuplicatePayAdvice.class),
//    DUPLICATE_PA_APPROVE("Approve a Duplicate Pay Advice SR", false, SrDuplicatePayAdvice.class),
//    DUPLICATEPAYMENTADVICE_CLOSE("Close Duplicate Payment Advice", false, SrDuplicatePayAdvice.class),
//    DUPLICATE_PAYADVICE_REJ("Reject a duplicate pay advice SR", false, SrDuplicatePayAdvice.class),
//    DUPLICATE_PAYADVICE_REOPEN("Reopen a duplicate pay advice SR,", false, SrDuplicatePayAdvice.class),
//
//    MERCHANT_DEINSTALLATION_CRE("Create a Merchant De-Install SR", false, SrMerchantDeinstallation.class),
//    MERCHANT_DEINSTALLATION_APPROVE("Approve a Merchant De-Install SR", false, SrMerchantDeinstallation.class),
//    MERCHANT_DEINSTALLATION_CLOSE("Close a Merchant De-Install SR", false, SrMerchantDeinstallation.class),
//    MERCHANT_DEINSTALLATION_REJ("Reject a merchant installation SR", false, SrMerchantDeinstallation.class),
//    MERCHANT_DEINSTALLATION_REOPEN("Reopen a merchant installation SR", false, SrMerchantDeinstallation.class),
//
//    SRMERCHANTCHAIN_CRE("Create a SRMerchantChain", false, SrMerchantChain.class),
//    SRMERCHANTCHAIN_APPROVE("Approve a SRMerchantChain", false, SrMerchantChain.class),
//    SRMERCHANTCHAIN_CLOSE("Close a SRMerchantChain", false, SrMerchantChain.class),
//    MERCHANT_CHAIN_REJ("Reject a merchant chain SR", false, SrMerchantChain.class),
//    MERCHAINT_CHAIN_REOPEN("Reopen a merchant chain SR", false, SrMerchantChain.class),
//
//    CHAIN_MERCHANTCHAIN_CRE("Create a  Add Chain SR", false, ChainSrAddChain.class),
//    CHAIN_MERCHANTCHAIN_APPROVE("Approve a Add Chain SR", false, ChainSrAddChain.class),
//    CHAIN_MERCHANTCHAIN_CLOSE("Close a Add Chain SR", false, ChainSrAddChain.class),
//    CHAIN_MERCHANT_CHAIN_REJ("Reject a Add Chain SR", false, ChainSrAddChain.class),
//    CHAIN_MERCHANT_CHAIN_REOPEN("Reopen a Add Chain SR", false, ChainSrAddChain.class),
//
//    STATEMENT_OPTION_CRE("Create a Statement Option", false, SrStatementOptions.class),
//    STATEMENT_OPTION_APPROVE("Approve a Statement Option", false, SrStatementOptions.class),
//    STATEMENT_OPTION_CLOSE("Close a Statement Option", false, SrStatementOptions.class),
//    STATMENT_OPTION_REJ("Reject a Statement Option SR", false, SrStatementOptions.class),
//    STATEMENT_OPTION_REOPEN("Reopen a Statement Option SR", false, SrStatementOptions.class),
//
//    CHAIN_STATEMENT_OPTION_CRE("Create a Chain Statement Option", false, ChainSrStatementOptions.class),
//    CHAIN_STATEMENT_OPTION_APPROVE("Approve a Chain Statement Option", false, ChainSrStatementOptions.class),
//    CHAIN_STATEMENT_OPTION_CLOSE("Close a Chain Statement Option", false, ChainSrStatementOptions.class),
//    CHAIN_STATMENT_OPTION_REJ("Reject a Chain Statement Option SR", false, ChainSrStatementOptions.class),
//    CHAIN_STATMENT_OPTION_REOPEN("Reopen a Chain Statement Option SR", false, ChainSrStatementOptions.class),
//
//    INTERNET_PAYMENT_GATEWAY_CRE("Create an Internet Payment Gateway", false, SrInternetPaymentGateway.class),
//    INTERNET_PAYMENT_GATEWAY_APPROVE("Approve an Internet Payment Gateway", false, SrInternetPaymentGateway.class),
//    INTERNET_PAYMENT_GATEWAY_CLOSURE("Close a Internet Payment Gateway", false, SrInternetPaymentGateway.class),
//    INTERNET_PAYEMNT_REJ("Reject a Internet payment SR", false, SrInternetPaymentGateway.class),
//    INTERNET_PAYEMNT_REOPEN("Reopen a Internet payment SR", false, SrInternetPaymentGateway.class),
//
//    ADD_SECONDARY_OWNER_CRE("Create a Secondary Owner", false, SrAddSecondaryOwner.class),
//    ADD_SECONDARY_OWNER_APPROVE("Approve a Secondary Owner", false, SrAddSecondaryOwner.class),
//    ADD_SECONDARY_OWNER_CLOSE("Close a Secondary Owner", false, SrAddSecondaryOwner.class),
//    ADD_SECONDARYOWNER_REJ("Reject Add secondary owner SR", false, SrAddSecondaryOwner.class),
//    ADD_SECONDRYOWNER_REOPEN("Reopen Add secondry owner SR", false, SrAddSecondaryOwner.class),
//
//    CURRENCY_CRE("Create a Currency SR", false, SrCurrencyChange.class),
//    CURRENCY_APPROVE("Approve Currency SR", false, SrCurrencyChange.class),
//    CURRENCY_CLOSE("Close a Currency SR", false, SrCurrencyChange.class),
//    CURRENCY_CHANGE_REJ("Reject a Currency change SR", false, SrCurrencyChange.class),
//    CURRENCY_CHANGE_REOPEN("Reopen a currency change SR", false, SrCurrencyChange.class),
//
//    OPERATING_TIMES_CRE("Create Operating Times SR", false, SrOperatingTime.class),
//    OPERATING_TIMES_APPROVE("Approve an Operating Times SR", false, SrOperatingTime.class),
//    OPERATING_TIMES_CLOSE("Close a Operating Times SR", false, SrOperatingTime.class),
//    OPERATING_TIMES_REJ("Reject a operating times SR", false, SrOperatingTime.class),
//    OPERATING_TIMES_REOPEN("Reopen a operating time SR", false, SrOperatingTime.class),
//
//    PAYMENT_ACCOUNT_CRE("Create a Payment Account SR", false, SrPaymentAccount.class),
//    PAYMENT_ACCOUNT_APPROVE("Approve a Payment Account SR", false, SrPaymentAccount.class),
//    PAYMENT_ACCOUNT_CLOSE("Close a Payment Account SR", false, SrPaymentAccount.class),
//    PAYMENT_ACCOUNT_REJ("Reject a payment account SR", false, SrPaymentAccount.class),
//    PAYMENT_ACCOUNT_REOPEN("Reopen a payment account SR", false, SrPaymentAccount.class),
//
//    PROFILE_CRE("Create a Profile SR", false, SrProfile.class),
//    PROFILE_APPROVE("Approve a Profile SR", false, SrProfile.class),
//    PROFILE_CLOSE("Close a Profile SR", false, SrProfile.class),
//    PROFILE_REJ("Reject a Profile SR", false, SrProfile.class),
//    PROFILE_REOPEN("Reopen a Profile SR ", false, SrProfile.class),
//
//    OFFERS_CRE("Create a Offer SR", false, SrOffers.class),
//    OFFERS_APPROVE("Approve a Offer SR", false, SrOffers.class),
//    OFFERS_CLOSE("Close a Offer SR", false, SrOffers.class), OFFERS_REJ("Reject a Offer SR", false, SrOffers.class),
//    OFFERS_REOPEN("Reopen a Offer SR", false, SrOffers.class),
//
//    TECHNICAL_ISSUE_CRE("Create a Technical Issue SR", true, SrTechnicalIssue.class),
//    TECHNICAL_ISSUE_APPROVE("Approve a Technical Issue SR", true, SrTechnicalIssue.class),
//    TECHNICAL_ISSUE_CLOSE("Close a Technical Issue SR", true, SrTechnicalIssue.class),
//    TECHNICAL_ISSUE_REJ("Reject a Technical Issue SR", true, SrTechnicalIssue.class),
//    TECHNICAL_ISSUE_REOPEN("Reopen TEchnical issue SR", true, SrTechnicalIssue.class),
//
//    CONSUMER_OFFERS_CRE("Create a Consumer Offer SR", false, SrConsumerOffers.class),
//    CONSUMER_OFFERS_APPROVE("Approve a Consumer Offer SR", false, SrConsumerOffers.class),
//    CONSUMER_OFFERS_CLOSE("Close a Consumer Offer SR", false, SrConsumerOffers.class),
//    CONSUMER_OFFERS_REJ("Reject a Consumer Offer SR", false, SrConsumerOffers.class),
//    CONSUMER_OFFERS_REOPEN("Reopen a Consumer Offer SR", false, SrConsumerOffers.class),
//
//    ICA_CRE("Create a ICA SR", false, SRIca.class), ICA_APPROVE("Approve a ICA SR", false, SRIca.class),
//    ICA_CLOSE("Close a ICA SR", false, SRIca.class), ICA_REJ("Reject a ICA SR", false, SRIca.class),
//    ICA_REOPEN("Reopen a ICA SR", false, SRIca.class),
//
//    CHANGE_OF_OWNERSHIP_CRE("Create a Change Ownership SR", false, SrChangeOfOwnership.class),
//    CHANGE_OF_OWNERSHIP_APPROVE("Approve Change Ownership SR", false, SrChangeOfOwnership.class),
//    CHANGE_OF_OWNERSHIP_CLOSE("Close a Change Ownership SR", false, SrChangeOfOwnership.class),
//    ADD_CHANGEOFOWNERSHIP_REJ("Reject change of ownership SR", false, SrChangeOfOwnership.class),
//    CHANGE_OF_OWNERSHIP_REOPEN("Reopen a change of ownership SR", false, SrChangeOfOwnership.class),
//
//    SRCOMMUNICATION_CRE("Create a SR Communication", false, SrCommunicationChannel.class),
//    SRCOMMUNICATION_APPROVE("Approve a SR Communication", false, SrCommunicationChannel.class),
//    SRCOMMUNICATION_CLOSE("Close a SR Communication", false, SrCommunicationChannel.class),
//    COMM_CHANNEL_REJ("Reject a SR Communication", false, SrCommunicationChannel.class),
//    COMM_CHANNEL_REOPEN("Reopen a SR Communication", false, SrCommunicationChannel.class),
//
//    KYC_CRE("Create a KYC SR", false, SrKyc.class), KYC_APPROVE("Approve a KYC SR", false, SrKyc.class),
//    KYC_CLOSE("Close a KYC SR", false, SrKyc.class), KYC_REJ("Reject a KYC SR", false, SrKyc.class),
//    KYC_REOPEN("Reopen a KYC SR", false, SrKyc.class),
//
//    ADDDISPUTE_CRE("Create a ADD Dispute SR", false, SRAddDispute.class),
//    ADDDISPUTE_APPROVE("Approve a Add Dispute SR", false, SRAddDispute.class),
//    ADDDISPUTE_CLOSE("Close a Add Dispute SR", false, SRAddDispute.class),
//    ADD_DISPUTE_REJ("Reject a add dispute SR", false, SRAddDispute.class),
//    ADD_DISPUTE_REOPEN("Reopen a Add Dispute SR", false, SRAddDispute.class),
//
//    PAYMENT_OPTION_CRE("Create a Payment Option SR", false, SrPaymentOption.class),
//    PAYMENT_OPTION_APPROVE("Approve a Payment Option SR", false, SrPaymentOption.class),
//    PAYMENT_OPTION_CLOSE("Close a Payment Option SR", false, SrPaymentOption.class),
//    PAYMENT_OPTION_REJ("Reject a payment option SR", false, SrPaymentOption.class),
//    PAYMENT_OPTION_REOPEN("Reopen a payment option SR", false, SrPaymentOption.class),
//
//    POS_TERMINAL_INITIALIZE_CRE("Create a POS Terminal Install", false, SRPOSTerminalInitialization.class),
//    POS_TERMINAL_INITIALIZE_APPROVE("Approve a POS Terminal Install", false, SRPOSTerminalInitialization.class),
//    POS_TERMINAL_INITIALIZE_REJ("Reject a POS Terminal Install", false, SRPOSTerminalInitialization.class),
//    POS_TERMINAL_INITIALIZE_CLOSE("Close a POS Terminal Install", false, SRPOSTerminalInitialization.class),
//    POS_TERMINAL_INITIALIZE_REOPEN("Reopen a POS Terminal Install", false, SRPOSTerminalInitialization.class),
//
//    CHAIN_PAYMENT_OPTION_CRE("Create a Chain Payment Option SR", false, ChainSrPaymentOption.class),
//    CHAIN_PAYMENT_OPTION_APPROVE("Approve a Chain Payment Option SR", false, ChainSrPaymentOption.class),
//    CHAIN_PAYMENT_OPTION_CLOSE("Close a Chain Payment Option SR", false, ChainSrPaymentOption.class),
//    CHAIN_PAYMENT_OPTION_REJ("Reject a Chain payment option SR", false, ChainSrPaymentOption.class),
//    CHAIN_PAYMENT_OPTION_REOPEN("Reopen a chain payment option SR", false, ChainSrPaymentOption.class),
//
//    RETRIEVAL_REQUEST_CRE("Create a Retrieval Request SR", false, SrRetrievalRequest.class),
//    RETRIEVAL_REQUEST_CLOSE_FULFILMENT("Close a Retrieval Request fulfil SR", false, SrRetrievalRequest.class),
//    RETRIEVAL_REQUEST_CLOSE_NONFULFIMENT("Close a Retrieval Request Non fulfil SR", false,
//            SrRetrievalRequest.class),
//    RETRIEVAL_REQUEST_REJ("Reject a Retrieval Request SR", false, SrRetrievalRequest.class),
//    RETRIEVAL_REQUEST_REOPEN("Reopen a Retrieval Request SR", false, SrRetrievalRequest.class),
//
//    CHARGEBACK_CRE("Create a Chargeback SR", false, SrChargeback.class),
//    CHARGEBACK_APPROVE("Approve a Chargeback SR", false, SrChargeback.class),
//    CHARGEBACK_CLOSE_FULFIL("Close a Chargeback fulfil SR", false, SrChargeback.class),
//    CHARGEBACK_CLOSE_NONFULFIL("Close a Chargeback non fulfil SR", false, SrChargeback.class),
//    CHARGEBACK_REJ("Reject chargeback SR", false, SrChargeback.class),
//    CHARGEBACK_REOPEN("Reopen a ChargeBack SR", false, SrChargeback.class),
//
//    //added new events for dispute
//
//    DISPUTE_ACCEPT("Dispute has been Accepted", false, DisputeManagement.class),
//    DISPUTE_CREATE("Dispute has been Created", false, DisputeManagement.class),
//    DISPUTE_REJECT("Dispute has been Rejected", false, DisputeManagement.class),
//    DISPUTE_CLOSE("Dispute has been Closed", false, DisputeManagement.class),
//
//    RR_ACCEPT("RR has been Accepted", false, DisputeManagement.class),
//    RR_CREATE("RR has been Created", false, DisputeManagement.class),
//    RR_REJECT("RR has been Rejected", false, DisputeManagement.class),
//    RR_CLOSED("RR has been Closed", false, DisputeManagement.class),
//
//    CB_ACCEPT("CB has been Accepted", false, DisputeManagement.class),
//    CB_CREATE("CB has been Created", false, DisputeManagement.class),
//    CB_REJECT("CB has been Rejected", false, DisputeManagement.class),
//    CB_CLOSED("CB has been Closed", false, DisputeManagement.class),
//
//    CONTACT_DETAIL_CRE("Create a Contact Details Update SR", false, SrContactDetailUpdate.class),
//    CONTACT_DETAIL_APPROVE("Approve a Contact Details Update SR", false, SrContactDetailUpdate.class),
//    CONTACT_DETAIL_CLOSE("Close a Contact Details Update SR", false, SrContactDetailUpdate.class),
//    CONTACT_DETAIL_UPD_REJ("Reject a Contact Details update SR", false, SrContactDetailUpdate.class),
//    CONTACT_DETAIL_UPD_REOPEN("Reopen a Contact Details update SR", false, SrContactDetailUpdate.class),
//
//    CHAIN_CONTACT_DETAIL_CRE("Create a Chain Contact Details Update SR", false, ChainSrContactDetailsUpdate.class),
//    CHAIN_CONTACT_DETAIL_APPROVE("Approve a Chain Contact Details Update SR", false,
//            ChainSrContactDetailsUpdate.class),
//    CHAIN_CONTACT_DETAIL_CLOSE("Close a Chain Contact Details Update SR", false, ChainSrContactDetailsUpdate.class),
//    CHAIN_CONTACT_DETAIL_UPD_REJ("Reject a Chain Contact Details update SR", false,
//            ChainSrContactDetailsUpdate.class),
//    CHAIN_CONTACT_DETAIL_REOPEN("Reopen a Chain contact Details update SR", false,
//            ChainSrContactDetailsUpdate.class),
//
//    DUPLICATESTATEMENT_CRE("Create a Duplicate Statement SR", false, SrDuplicateStatement.class),
//    DUPLICATESTATEMENT_CLOSE("Close a Duplicate Statement SR", false, SrDuplicateStatement.class),
//    DUPLICATE_STATEMENT_APPROVE("Approve a Duplicate Statment SR", false, SrDuplicateStatement.class),
//    DUPLICATE_STATMENT_REJ("Reject a Duplicate statement SR", false, SrDuplicateStatement.class),
//    DUPLICATE_STATMENT_REOPEN("Reopen a Duplicate statement SR", false, SrDuplicateStatement.class),
//
//    TALKTORM_CRE("Create a Talk-To-RM SR", false, SrTalkRm.class),
//    TALK_APPROVE("Approve Talk to RM SR", false, SrTalkRm.class),
//    TALKTORM_CLOSE("CLose a Talk-To-RM SR", false, SrTalkRm.class),
//    TALKRM_REJ("Reject a Talk to RM SR", false, SrTalkRm.class),
//    TALKTORM_REOPEN("Reopen a Talk to RM SR", false, SrTalkRm.class),
//
//    RECONISSUE_CRE("Create a Re-ConIssue", true, SrReconissue.class),
//    RECONISSUE_APPROVE("Approve Reconissue SR", true, SrReconissue.class),
//    RECONISSUE_REASSIGN_APPROVE("Recon Issue SR Re-Assign", true, SrReconissue.class),
//    RECONISSUE_REJ("Reject a Reconissue SR", true, SrReconissue.class),
//    RECONISSUE_CLOSE("Close Re-ConIssue", true, SrReconissue.class),
//    RECONISSUE_REOPEN("Reopen a Recon Issue SR", true, SrReconissue.class),
//
//    PWD_CHANGE_APPROVE("Approve Password change SR", false, SrPwdChange.class),
//    PWD_CHANGE_REJECT("Reject pasword change SR", false, SrPwdChange.class),
//    PWD_CHANGE_CLOSE("Closure Password change SR", false, SrPwdChange.class),
//
//    CHARGEBACKINQ_CRE("Create a Chargeback Inquiry SR", false, SrChargebackInq.class),
//    CHARGEBACKINQ_APPROVE("Approve a Chargeback Inquiry SR", false, SrChargebackInq.class),
//    CHARGEBACKINQ_CLOSE("Close a Chargeback Inquiry SR", false, SrChargebackInq.class),
//    CHARGEBACKINQ_REJ("Reject chargeback inq SR", false, SrChargebackInq.class),
//
//    BLOCK_AUTH_CRE("Create a Block Auth SR", false, SrBlockAuth.class),
//    BLOCK_AUTH_APPROVE("Approve a Block Auth SR", false, SrBlockAuth.class),
//    BLOCK_AUTH_CLOSE("Close a Block Auth SR", false, SrBlockAuth.class),
//    BLOCK_AUTH_REJ("Reject a Block Auth SR", false, SrBlockAuth.class),
//    BLOCK_AUTH_REOPEN("Reopen a Block Auth SR", false, SrBlockAuth.class),
//
//    CHAIN_BLOCK_AUTH_CRE("Create a Chain Block Auth SR", false, ChainSrAuthBlock.class),
//    CHAIN_BLOCK_AUTH_APPROVE("Approve a Chain Block Auth SR", false, ChainSrAuthBlock.class),
//    CHAIN_BLOCK_AUTH_CLOSE("Close a Chain Block Auth SR", false, ChainSrAuthBlock.class),
//    CHAIN_BLOCK_AUTH_REJ("Reject a Chain Block Auth SR", false, ChainSrAuthBlock.class),
//    CHAIN_BLOCK_AUTH_REOPEN("Reopen aChain Auth SR", false, ChainSrAuthBlock.class),
//
//    CHAIN_DEFAULT_MERCHANT_CRE("Create a Chain Default Merchant SR", false, ChainSrDefaultMerchant.class),
//    CHAIN_DEFAULT_MERCHANT_APPROVE("Approve a Chain Default Merchant SR", false, ChainSrDefaultMerchant.class),
//    CHAIN_DEFAULT_MERCHANT_CLOSE("Close a Chain Default Merchant SR", false, ChainSrDefaultMerchant.class),
//    CHAIN_DEFAULT_MERCHANT_REJ("Reject a Chain Default Merchant SR", false, ChainSrDefaultMerchant.class),
//    CHAIN_DEFAULT_MERCHANT_REOPEN("Reopen a Chain Default Merchant SR", false, ChainSrDefaultMerchant.class),
//
//    SR_USERS_COMMUNICATION("SR Users Communication", false, SrUsersCommunicationVO.class),
//    SR_USER_COMM_CUSTOM("Custom SR Users Communication", false, CustomSrUserCommunicationVO.class),
//    E_RECEIPT("E_Receipt Communication", false, DigitalChargeSlip.class),
//    PAY_LINK_REPORT("PayLink Report", false, PaymentLinkVO.class),
//    PAYMENT_LINK("Payment Link", false, PaymentLinkVO.class), FRAUD("Fraud case", false, FraudNotificationVO.class),
//    PAYMENT_HOLD("Payment Hold case", false, FraudNotificationVO.class),
//    FALLBACK_FEE("Fallabck Fee", false, FeeNotificationVO.class),
//    UTILITY_FEE("Utility Fee", false, FeeNotificationVO.class),
//    CONVENIENCE_FEE("Convenience Fee", false, FeeNotificationVO.class),
//    SURCHARGE_FEE("Surcharge Fee", false, FeeNotificationVO.class),
//    LATE_SETTLEMENT_FEE("Late Settlemen Fee", false, FeeNotificationVO.class),
//    MEMBERSHIP_FEE("Membership Fee", false, FeeNotificationVO.class),
//    ADMIN_FEE("Admin Fee", false, FeeNotificationVO.class),
//    DUP_PA_FEE("Duplicate PA Fee", false, FeeNotificationVO.class),
//    DUP_EMAIL_PA_FEE("Duplicate Email PA Fee", false, FeeNotificationVO.class),
//    DUP_STMT_FEE("Duplicate Statement Fee", false, FeeNotificationVO.class),
//    DUP_EMAIL_STMT_FEE("Duplicate Email Statement Fee", false, FeeNotificationVO.class),
//    CHARGEBACK_FEE("Chargeback Fee", false, FeeNotificationVO.class),
//    USER_FEE("User Fee", false, FeeNotificationVO.class),
//    PROCESSING_FEE("Processing Fee", false, FeeNotificationVO.class),
//    NSF("Non Sufficient Fee", false, FeeNotificationVO.class),
//    SETUP_FEE("Setup Fee", false, FeeNotificationVO.class),
//    SUPPLY_FEE("Supply Fee", false, FeeNotificationVO.class), RENT_FEE("Rent Fee", false, FeeNotificationVO.class),
//    DEINSTALLATION_FEE("Deinstallation Fee", false, FeeNotificationVO.class),
//    REPLACEMENT_FEE("Replacement Fee", false, FeeNotificationVO.class),
//    OFFERS("Offers Communication", false, Offers.class),
//    CHAIN_SR_PAYMENT_ACCOUNT_CRE("Create a Chain Payment Account SR", false, ChainSrPaymentAccount.class),
//    CHAIN_SR_PAYMENT_ACCOUNT_APPROVE("Approve a Chain Payment Account SR", false, ChainSrPaymentAccount.class),
//    CHAIN_SR_PAYMENT_ACCOUNT_CLOSURE("Close a Chain Payment Account SR", false, ChainSrPaymentAccount.class),
//    CHAIN_SR_PAYMENT_ACCOUNT_REJ("Reject a Chain Payment Account SR", false, ChainSrPaymentAccount.class),
//    CHAIN_SR_PAYMENT_ACCOUNT_REOPEN("Reopen a Chain Payment Account SR", false, ChainSrPaymentAccount.class),
//
//    USER_SERVICE_CRE("Create User SR", true, SrUser.class),
//    USER_SERVICE_APPROVE("Approve User SR", true, SrUser.class),
//    USER_SERVICE_CLOSE("Close User SR", true, SrUser.class), USER_SERVICE_REJ("Reject User SR", true, SrUser.class),
//    USER_SERVICE_REOPEN("Re-open User SR", true, SrUser.class),
//
//    EXTERNAL_USERSR_CRE("Exernal User SR Create", false, SrUser.class),
//    EXTERNAL_USERSR_APPROVE("Exernal User SR Approve", false, SrUser.class),
//    EXTERNAL_USERSR_CLOSE("Exernal User SR Close", false, SrUser.class),
//    EXTERNAL_USERSR_REJ("Exernal User SR Reject", false, SrUser.class),
//    EXTERNAL_USERSR_REOPEN("Exernal User SR Re-open", false, SrUser.class),
//
//    REGISTER_BATCH_PAY_CRE("Create Register Batch Pay SR", false, SRRegisterBatchPay.class),
//    REGISTER_BATCH_PAY_APPROVE("Approve Register Batch Pay SR", false, SRRegisterBatchPay.class),
//    REGISTER_BATCH_PAY_CLOSE("Close a Register Batch Pay SR", false, SRRegisterBatchPay.class),
//    REGISTER_BATCH_PAY_REJ("Reject a Register Batch Pay SR", false, SRRegisterBatchPay.class),
//    REGISTER_BATCH_PAY_REOPEN("Reopen a Register Batch Pay SR", false, SRRegisterBatchPay.class),
//
//    DE_REGISTER_BATCH_PAY_CRE("Create DeRegister Batch Pay SR", false, SRDeRegisterBatchPay.class),
//    DE_REGISTER_BATCH_PAY_APPROVE("Approve DeRegister Batch Pay SR", false, SRDeRegisterBatchPay.class),
//    DE_REGISTER_BATCH_PAY_CLOSE("Close DeRegister Batch Pay SR", false, SRDeRegisterBatchPay.class),
//    DE_REGISTER_BATCH_PAY_REJ("Reject DeRegister Batch Pay SR", false, SRDeRegisterBatchPay.class),
//
//    TERMINALS_ACTINA_CRE("Create Terminal Active Inactive SR", false, SrTerminalActiveInactive.class),
//    TERMINALS_ACTINA_APPROVE("Approve Terminal Active Inactive SR", false, SrTerminalActiveInactive.class),
//    TERMINALS_ACTINA_CLOSE("Close Terminal Active Inactive SR", false, SrTerminalActiveInactive.class),
//    TERMINALS_ACTINA_REJ("Reject Terminal Active Inactive SR", false, SrTerminalActiveInactive.class),
//    TERMINALS_ACTINA_REOPEN("Reopen Terminal Active Inactive SR", false, SrTerminalActiveInactive.class),
//
//    MERCHANT_ACTINA_CRE("Create Merchant Active Inactive SR", false, SrMerchantActiveInactive.class),
//    MERCHANT_ACTINA_APPROVE("Approve Merchant Active Inactive SR", false, SrMerchantActiveInactive.class),
//    MERCHANT_ACTINA_CLOSE("Close Merchant Active Inactive SR", false, SrMerchantActiveInactive.class),
//    MERCHANT_ACTINA_REJ("Reject Merchant Active Inactive SR", false, SrMerchantActiveInactive.class),
//    MERCHANT_ACTINA_REOPEN("Reopen Merchant Active Inactive SR", false, SrMerchantActiveInactive.class),
//
//    ADD_MERCHANT_AND_TERMINAL_PROVIDERS_CRE("Create Add Provider SR", false, SrAddProviders.class),
//    ADD_MERCHANT_AND_TERMINAL_PROVIDERS_APPROVE("Approve Add Provider SR", false, SrAddProviders.class),
//    ADD_MERCHANT_AND_TERMINAL_PROVIDERS_CLOSE("Close Add Provider SR", false, SrAddProviders.class),
//    ADD_MERCHANT_AND_TERMINAL_PROVIDERS_REJ("Reject Add Provider SR", false, SrAddProviders.class),
//    ADD_MERCHANT_AND_TERMINAL_PROVIDERS_REOPEN("Reopen Add Provider SR", false, SrAddProviders.class),
//
//    SR_MERCHANT_TERMINAL_CONSUMER_CRE("Create a merchant terminal consumer SR", false,
//            SrMerchantTerminalConsumer.class),
//    SR_MERCHANT_TERMINAL_CONSUMER_APPROVE("Approve a merchant terminal consumer SR", false,
//            SrMerchantTerminalConsumer.class),
//    SR_MERCHANT_TERMINAL_CONSUMER_CLOSE("Close a merchant terminal consumer SR", false,
//            SrMerchantTerminalConsumer.class),
//    SR_MERCHANT_TERMINAL_CONSUMER_REJECT("Reject a merchant terminal consumer SR", false,
//            SrMerchantTerminalConsumer.class),
//    SR_MERCHANT_TERMINAL_CONSUMER_REOPEN("Reopen a merchant terminal consumer SR", false,
//            SrMerchantTerminalConsumer.class),
//    SOCKET_ACTIVE_DEACTIVE("Socket Active or Deactive", true, ConnectionStatusVO.class),
//    SIGNON_SIGNOFF("SIGN ON OR OFF", true, ConnectionStatusVO.class),
//
//    REFUND_INITIATED("Refund Initiated", false, AuthorizationMessageVO.class);
//
//    private String action;
//
//    private Boolean isInternalType;
//
//    private Class<?> linkedVOClass;
//
//    public Boolean getIsInternalType() {
//        return this.isInternalType;
//    }
//
//    public String getAction() {
//        return this.action;
//    }
//
//    public Class<?> getLinkedClass() {
//        return this.linkedVOClass;
//    }
//
//    private EventEnum(String action, Boolean isInternalType, Class<?> linkedVOClass) {
//        this.isInternalType = isInternalType;
//        this.action = action;
//        this.linkedVOClass = linkedVOClass;
//    }
//}
//
//public enum NotificationTypeEnum {
//    PAYMENT, OFFER, REQUEST, PAYMENT_REJECT, FEE, PAYMENT_HOLD, FRAUD
//}
//
//public enum TaxesEnum {
//    SERVICE, CGST, SGST, IGST
//}
//
//public enum FeeFrequencyEventEnum {
//    EVENT, STATEMENT, MONTHLY, ANNUALLY, QUARTERLY
//}
//
//public enum TotalLevelEnum {
//    MERCHANT, CHAIN, STORE
//}
//
//public enum NumberGenerationEnum {
//
//    RANDOM, INCREMENT, INPUT, TP1, SEGMENT, PREGEN_RANGE, MERCHANT_HASH, TERMINAL_TYPE
//}
//
//public enum E_Statement_passwordEnum {
//    ESPTP1
//}
//
//public enum ServiceRequestEnum {
//    SRNRDM, SRNTP1, DISRDNM
//}
//
//public enum FeeEnum {
//    LATE_SETTLE, CONVENIENCE, SURCHARGE, FALLBACK, STATEMENT, PA, SETUP, SUPPLY, MEMBERSHIP, ADMIN, TURNOVER, CBACK,
//    MISC, RENTAL, SERVICE, DEINSTALL, EMAIL_DUP_PA, REPLACEMENT, EMAIL_DUP_STMT, DUP_STMT, NSF, PROCESSING,
//    UTY_BILL_PMT, USER, TXN_FEE_1, TXN_FEE_2, TXN_FEE_3, DUP_PA
//}
//
//public enum FRMSegmentControlEnum {
//    DORMANT_DAYS, NON_OPERATING_HOURS, SUSPICIOUS_MULTIPLE_TRANSACTIONS, HIGH_VALUE_TICKETS, HIGHEST_DAY_VOLUME,
//    SUSPICIOUS_CONTACTLESS_TRANSACTIONS, SUSPICIOUS_FALLBACK_TRANSACTIONS, SUSPICIOUS_NON_EMV,
//    SUSPICIOUS_HIGH_FLOW_COUNT, SUSPICIOUS_HIGH_FLOW_AMOUNT, SUSPICIOUS_HIGH_VELOCITY_TRANSACTIONS
//}
//
//public enum FraudRiskActionEnum {
//    ALERT, PAYMENT_HOLD
//}
//
//public enum FraudRiskAuthActionEnum {
//    ALLOW, DECLINE, ALLOW_ALERT, DECLINE_ALERT, HOLD_PAYMENT;
//
//    public static FraudRiskAuthActionEnum deriveAction(FraudRiskAuthActionEnum currAction,
//                                                       FraudRiskAuthActionEnum newAction) {
//
//        if (currAction == null) {
//            if (newAction == null) {
//                return FraudRiskAuthActionEnum.ALLOW;
//            } else {
//                return newAction;
//            }
//        }
//        if (newAction == null) {
//            newAction = FraudRiskAuthActionEnum.ALLOW;
//        }
//        if (newAction.equals(FraudRiskAuthActionEnum.HOLD_PAYMENT)) {
//            return FraudRiskAuthActionEnum.DECLINE;
//        }
//        if (currAction.equals(DECLINE_ALERT) || newAction.equals(DECLINE_ALERT)) {
//            return FraudRiskAuthActionEnum.DECLINE_ALERT;
//        }
//        if (currAction.equals(DECLINE) || newAction.equals(DECLINE)) {
//            return FraudRiskAuthActionEnum.DECLINE;
//        }
//        if (currAction.equals(ALLOW_ALERT) || newAction.equals(ALLOW_ALERT)) {
//            return FraudRiskAuthActionEnum.ALLOW_ALERT;
//        }
//        return FraudRiskAuthActionEnum.ALLOW;
//    }
//
//    public String getResoneCodeBasedOnAction() {
//        switch (this) {
//            case DECLINE_ALERT:
//                return "FA";
//            case DECLINE:
//                return "FR";
//            default:
//                return "00";
//        }
//    }
//
//    public Boolean isAllowed() {
//        if (this.equals(FraudRiskAuthActionEnum.ALLOW) || this.equals(FraudRiskAuthActionEnum.ALLOW_ALERT)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//}
//
//public enum FileFlagEnum {
//    INCOMING_RUPAY, OUTGOING_RUPAY, INCOMING_VISA, OUTGOING_VISA, INCOMING_MC, OUTGOING_MC, REPORTS, OUTGOING
//}
//
//public enum accountingEnum {
//    OPENING_BALANCE("Opening Balance"),
//
//    MER_ACQ_VOID("Transactions Void"),
//    MER_ACQ_OG_VISA("SDRS Outgoing Claims Visa"),
//    MER_ACQ_OG_MC("SDRS Outgoing Claims MC "),
//    MER_ACQ_OG_RUPAY("SDRS Outgoing Claims Rupay"),
//    MER_ACQ_APPROVED("Approved Transactions "),
//
//    MER_PAY_VOID("Transactions Void"),
//    MER_PAY_HOLD("hold transaction"),
//    MER_PAY_REAL_TIME("Real Time Payment"),
//    MER_PAY_NON_REAL_TIME("non Real Time Payment"),
//    MER_PAY_APPROVED("Approved Transactions "),
//
//    SDRS_OG_RUPAY_SALES("outgoing claims purchase/sales Rupay"),
//    SDRS_OG_RUPAY_SALES_SETTLED("outgoing claims settled purchase/sales Rupay"),
//    SDRS_OG_RUPAY_REVERSALS("outgoing claims reversals Rupay"),
//    SDRS_OG_RUPAY_REVERSALS_SETTLED("outgoing claims settled reversals Rupay "),
//
//    SDRS_OG_VISA_SALES("outgoing claims purchase/sales Visa"),
//    SDRS_OG_VISA_SALES_SETTLED("outgoing claims settled purchase/sales Visa"),
//    SDRS_OG_VISA_REVERSALS("outgoing claims reversals Visa"),
//    SDRS_OG_VISA_REVERSALS_SETTLED("outgoing claims settled reversals Visa "),
//
//    SDRS_OG_MC_SALES("outgoing claims purchase/sales MC"),
//    SDRS_OG_MC_SALES_SETTLED("outgoing claims settled purchase/sales MC"),
//    SDRS_OG_MC_REVERSALS("outgoing claims reversals MC"),
//    SDRS_OG_MC_REVERSALS_SETTLED("outgoing claims settled reversals MC "),
//
//    MER_HOLD("hold transaction"),
//    MER_HOLD_RELEASE("hold release transaction"),
//    MER_HOLD_CHBK_IC_MC("hold chargeback transaction for master"),
//    MER_HOLD_CHBK_IC_RUPAY("hold chargeback transaction for rupay"),
//    MER_HOLD_CHBK_IC_VISA("hold chargeback transaction for visa"),
//
//    MER_REFUND_RECEIVABLE("Refund Receivable Transaction"),
//    MER_REFUND("Refund Transaction"),
//    MER_REFUND_OG_VISA("Refund Transaction Visa"),
//    MER_REFUND_OG_MC("Refund Transaction MC "),
//    MER_REFUND_OG_RUPAY("Refund Transaction Rupay"),
//
//    MER_ACC_HOLD_RELEASE("merchant account hold release"),
//    MER_ACC_NON_REAL_TIME("merchant account non Real Time Payment"),
//    MER_ACC_REAL_TIME("merchant account Real Time Payment"),
//    MER_ACC_DISPUTE_RECOVERY("merchant account dispute transaction recovery"),
//    MER_ACC_PROCESSING_FEE("merchant account processing fee"),
//    MER_ACC_ADMISSION_FEE("merchant account admission fee"),
//    MER_ACC_MEMBERSHIP_FEE("merchant account membership fee"),
//    MER_ACC_IP_ACTIVATION_FEE("merchant account IP activation fee"),
//    MER_ACC_STATEMENT("merchant account statement"),
//    MER_ACC_PAYMENT_ADVICE("merchant account payment advice fee"),
//    MER_ACC_SUPPLIES("merchant account Supplies fee"),
//    MER_ACC_TURNOVER("merchant account turnover fee"),
//    MER_ACC_MISCELLANEOUS("merchant account Miscellaneous fee"),
//    MER_ACC_RENTAL("merchant account rental fee"),
//    MER_ACC_SERVICE("merchant account service fee"),
//    MER_ACC_DE_INSTALLATION_CHARGES("merchant account de-installation charges"),
//    MER_ACC_DUPLICATE_PAYMENT_ADVICE("merchant account duplicate payment advice fee"),
//    MER_ACC_REPLACEMENT("merchant account replacement fee"),
//    MER_ACC_DUPLICATE_EMAIL_STATEMENT("merchant account duplicate email statement fee"),
//    MER_ACC_DUPLICATE_STATEMENT("merchant account duplicate statement fee"),
//
//    SS_TAX_COLL_NON_REAL_TIME("Tax collection non real Time Payment"),
//    SS_TAX_COLL_REAL_TIME("Tax collection real Time Payment"),
//
//    SD_INC_CHARG_IC_RUPAY("incoming chargaback for incoming rupay"),
//    SD_INC_CHARG_IC_MC("incoming chargaback for incoming master"),
//    SD_INC_CHARG_IC_VISA("incoming chargaback for incoming visa"),
//    SD_INC_CHARG_HOLD_RUPAY("incoming chargeback hold for rupay"),
//    SD_INC_CHARG_HOLD_MC("incoming chargeback hold for master"),
//    SD_INC_CHARG_HOLD_VISA("incoming chargeback hold for visa"),
//    SD_INC_CHARG_NON_HOLD_RUPAY("incoming chargeback non hold for rupay"),
//    SD_INC_CHARG_NON_HOLD_MC("incoming chargeback non hold for master"),
//    SD_INC_CHARG_NON_HOLD_VISA("incoming chargeback non hold for visa"),
//    SD_INC_CHARG_REJECT_RUPAY("incoming chargeback reject for rupay"),
//    SD_INC_CHARG_REJECT_MC("incoming chargeback reject for master"),
//    SD_INC_CHARG_REJECT_VISA("incoming chargeback reject for visa"),
//
//    CREDIT_ADJ_OG_RUPAY("Credit adjustment for outgoing rupay"),
//    CREDIT_ADJ_OG_MC("Credit adjustment for outgoing master"),
//    CREDIT_ADJ_OG_VISA("Credit adjustment for outgoing visa"),
//    CREDIT_ADJ_IC_RUPAY("Credit adjustment for incoming rupay"),
//    CREDIT_ADJ_IC_MC("Credit adjustment for incoming master"),
//    CREDIT_ADJ_IC_VISA("Credit adjustment for incoming visa"),
//
//    DEBIT_ADJ_OG_RUPAY("Debit adjustment for outgoing rupay"),
//    DEBIT_ADJ_OG_MC("Debit adjustment for outgoing master"),
//    DEBIT_ADJ_OG_VISA("Debit adjustment for outgoing visa"),
//    DEBIT_ADJ_IC_RUPAY("Debit adjustment for incoming rupay"),
//    DEBIT_ADJ_IC_MC("Debit adjustment for incoming master"),
//    DEBIT_ADJ_IC_VISA("Debit adjustment for incoming visa"),
//
//    MEM_FUND_COLL_OG_RUPAY("Member fund Collection for outgoing rupay"),
//    MEM_FUND_COLL_OG_MC("Member fund Collection for outgoing master"),
//    MEM_FUND_COLL_OG_VISA("Member fund Collection for outgoing visa"),
//    MEM_FUND_COLL_IC_RUPAY("Member fund Collection for incoming rupay"),
//    MEM_FUND_COLL_IC_MC("Member fund Collection for incoming master"),
//    MEM_FUND_COLL_IC_VISA("Member fund Collection for incoming visa"),
//
//    MEM_FUND_DISB_OG_RUPAY("Member fund disbursement for outgoing rupay"),
//    MEM_FUND_DISB_OG_MC("Member fund disbursement for outgoing master"),
//    MEM_FUND_DISB_OG_VISA("Member fund disbursement for outgoing visa"),
//    MEM_FUND_DISB_IC_RUPAY("Member fund disbursement for incoming rupay"),
//    MEM_FUND_DISB_IC_MC("Member fund disbursement for incoming master"),
//    MEM_FUND_DISB_IC_VISA("Member fund disbursement for incoming visa"),
//
//    SD_OUTGOING_CLAIMS_REPRES_IC_MC("outgoing claims represntment for incoming master"),
//    SD_OUTGOING_CLAIMS_REPRES_IC_RUPAY("outgoing claims represntment for incoming rupay"),
//    SD_OUTGOING_CLAIMS_REPRES_IC_VISA("outgoing claims represntment for incoming visa"),
//    SD_OUTGOING_CLAIMS_REPRES_REJECT_MC("chargeback reject outgoing claims represntment for master"),
//    SD_OUTGOING_CLAIMS_REPRES_REJECT_RUPAY("chargeback reject outgoing claims represntment for rupay"),
//    SD_OUTGOING_CLAIMS_REPRES_REJECT_VISA("chargeback reject outgoing claims represntment for visa"),
//
//    SD_OUTGOING_CLAIMS_REFUND_OG_MC("outgoing claims refund for outgoing master"),
//    SD_OUTGOING_CLAIMS_REFUND_OG_RUPAY("outgoing claims refund for outgoing rupay"),
//    SD_OUTGOING_CLAIMS_REFUND_OG_VISA("outgoing claims refund for outgoing visa"),
//    SD_OUTGOING_CLAIMS_REFUND_IC_MC("outgoing claims refund for incoming master"),
//    SD_OUTGOING_CLAIMS_REFUND_IC_RUPAY("outgoing claims refund for incoming rupay"),
//    SD_OUTGOING_CLAIMS_REFUND_IC_VISA("outgoing claims refund for incoming visa"),
//
//    INTERCHANGE_FEE_PURCHASE_MC("Interchange fee against the purchase txn settled for master"),
//    INTERCHANGE_FEE_PURCHASE_RUPAY("Interchange fee against the purchase txn settled for rupay"),
//    INTERCHANGE_FEE_PURCHASE_VISA("Interchange fee against the purchase txn settled for visa"),
//    INTERCHANGE_FEE_REVERSAL_MC("Interchange fee return of sale for master"),
//    INTERCHANGE_FEE_REVERSAL_RUPAY("Interchange fee return of sale for rupay"),
//    INTERCHANGE_FEE_REVERSAL_VISA("Interchange fee return of sale for visa"),
//
//    SS_MER_RECOVERY_AGAINST_DISPUTE_MC("Dispute Transaction Recovery for master"),
//    SS_MER_RECOVERY_AGAINST_DISPUTE_RUPAY("Dispute Transaction Recovery for rupay"),
//    SS_MER_RECOVERY_AGAINST_DISPUTE_VISA("Dispute Transaction Recovery for visa"),
//    SS_MER_RECOVERY_AGAINST_NON_HOLD_DISPUTE_MC("Dispute non hold Transaction Recovery for master"),
//    SS_MER_RECOVERY_AGAINST_NON_HOLD_DISPUTE_RUPAY("Dispute non hold Transaction Recovery for rupay"),
//    SS_MER_RECOVERY_AGAINST_NON_HOLD_DISPUTE_VISA("Dispute non hold Transaction Recovery for visa");
//
//
//
//    private String description;
//
//    private accountingEnum(String desc) {
//        this.description = desc;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//}
//
//public enum GeneralLedgerAccountEnum {
//    SSUS_MER_ACQ("Sundry Suspense Merchant Acquiring"),
//    SSUS_MER_PAY("Sundry Suspense Merchant Payables"),
//    SDRS_OUTGOING_CLAIMS("Sundry Debtors Outgoing Claims"),
//    SSUS_MER_HOLD("Sundry Suspense Merchant Holds"),
//    SSUS_MER_REF_RCVBLE("Sundry Suspense Merchant Refund Recievable"),
//    MERCHANT_ACCOUNT("MerchantAccount"),
//    SSUS_MER_REFUND("Sundry Suspense Merchant Refund"),
//    SSUS_MER_TAX("Sundry Suspense Merchant Tax"),
//    SDRS_INCOMING_CHBKS("Sundry Debtors Incoming Chargebacks"),
//    SS_Credit_Adjustment("Sundry Suspense Credit Adjustment"),
//    SS_Debit_Adjustment("Sundry Suspense Debit Adjustment"),
//    SS_Outgoing_Member_Fee_Collection("Sundry Suspense Outgoing Member Fund Collection"),
//    SS_Outgoing_Member_Fee_Disbursement("Sundry Suspense Outgoing Member Fund Disbursement"),
//    SDRS_OUTGOING_REPRS("Sundry Debtors Representments"),
//    SDRS_OUTGOING_REFUND("Sundry Debtors Refunds"),
//    SSUS_MER_RECOVERIES("Sundry Suspense Merchant Recovery");
//
//    private String accountName;
//
//    private GeneralLedgerAccountEnum (String accountName) {
//        this.accountName = accountName;
//    }
//
//    public String getAccountName() {
//        return this.accountName;
//    }
//}
//
//public enum ReportTypeEnum {
//    NOT_SETTLED, SETTLED, DISPUTED, RE_SETTLED, ARBITRATION, SCHEME_REJECT, ERROR_HOLD, ERROR, SUMMARY, DETAILED,
//    RE_PRESENTMENT, OUTGOING_SUMMARY, INCOMINGSUMMARY_RUPAY,INCOMINGSETTLED_RUPAY,INCOMINGSUMMARY_MASTER,INCOMINGSETTLED_MASTER,
//    INCOMINGSUMMARY_VISA,INCOMINGSETTLED_VISA, EOD, NETAMOUNT_JV, SUMMARY_OF_ACCOUNTS ,INCNOTSETTLED_RUPAY,INCNOTSETTLED_VISA,
//    INCNOTSETTLED_MASTER, EOD_SETTLED, EOD_NOTSETTLED, EOD_ERRORHOLD, DUPLICATE_BINS, MEMBERFUND, INCOMING_SUMMARY
//}
//
//public enum DurationAvgTxnEnum {
//    LASTMONTH, LAST3MONTHS, LAST6MONTHS
//}
//
//public enum TerminationReasonCode {
//    ACCOUNT_DATA_COMPROMISE, COMMON_POINTS_OF_PURCHASE, LAUNDERING, EXCESSIVE_CHARGEBACKS, EXCESSIVE_FRAUD,
//    RESERVED_FOR_FUTURE_USE, FRAUD_CONVICTION, MASTERCARD_QUESTIONABLE_MERCHANT_AUDIT_PROGRAM, BANKRUPTCY,
//    VIOLATION_OF_MASTERCARD_STANDARDS, MERCHANT_COLLUSION, PCI_DATA_SECURITY_STANDARD, NONCOMPLIANCE,
//    ILLEGAL_TRANSACTIONS, IDENTITY_THEFT
//
//}
//
//public enum AuthorizationStatusEnum {
//    VOID, REVERSAL, SUCCESS, REJECT, TIMEOUT
//}
//
//public enum StatisticsEnum {
//    SALES(1), TOTALTRANSACTION(2), APP_USER(3), MER_USER(4), SALES_REVENUE(5), PRICE_TBL(1), SR_CHANNEL_TYPE(2),
//    SR_CHANNEL_TIME(3), SR_USER(4), SR_ADD_TERMLS(5), MER_ENRLMNT(1), UW_RESUB(2), MER_ENRLMNT_PROD(3), DISPUTES(4),
//    REFUND_BY_MER_ON_CARD(5), FEE_POSTING(1), MERCHANT_DISPUTE(2), SR_TOTAL(3), SRSLACROSS(4), REJECT_REPOST(5),
//    HOLD_RELEASE(1), INCOMING_FILE_TRANSACTIONS(2), POSTING_REJECT_DCC_NOT_SUPP(3), MERCHANT_CHAIN_DELETED(4),
//    MERCHANT_CHAIN_ADDED(5), PAYMENT_RELEASED(1), TOTAL_MERCHANT(2), TOTAL_TERMINAL(3), MDR(5), DISPUTE_USER(4),
//    AUTH_APPROVE(5), AUTH_DECLINE(1), PREAUTH_APPROVE(2), PREAUTH_DECLINE(3), REVERSAL_APPROVE(4),
//    REVERSAL_DECLINE(5), PREAUTHCOMPLETION_APPROVE(1), PREAUTHCOMPLETION_DECLINE(2), REFUND_APPROVE(3),
//    REFUND_DECLINE(4), ADJUST_APPROVE(5), ADJUST_DECLINE(1), OUTGOING_CLAIMS(2), INCOMING_CLAIMS(3),
//    PENDING_CLEARING_CLAIMS(4), SURCHARGE(1), INTERCHANGE(2), MER_INTERCHANGE(3), TOTAL_AUTH(4), AUTH_STATUS(5),
//    AUTH_TYPE(1), AUTH_SCHEME(2), MER_REFUNDS(3), REFUNDS(4), MER_MDR(5), MER_POSTED_ACQ_TXN(1), POSTED_ACQ_TXN(2),
//    MER_TXN(5), POSTED_FEE(3), POSTED_FEE_REV(4), MER_POSTED_FEE(5), MER_POSTED_FEE_REV(1), TRANSACTION_TERMINAL(2),
//    AUTH_SUSPICIOUS_CARDBIN(3), FRMTRANSACTION(4), NON_TRANSACTION_HOURS_AUTH(5), NON_TRANSACTION_HOURS_SETTLE(5),
//    APPLICATION_LEAD(1), HIGHEST_DAY_VOLUME(2), HIGH_VALUE_TICKET(3), SUSPICIOUS_CONTACTLESS_SETTLE(3),
//    SUSPICIOUS_MULTIPLE_TRANSACTIONS(3), SUSPICIOUS_CONTACTLESS_AUTH(3), SUSPICIOUS_FALLBACK_SETTLE(3),
//    SUSPICIOUS_NONEMV_AUTH(3), SUSPICIOUS_NONEMV_SETTLE(3), DORMANT_AUTH(4), DORMANT_SETTLE(5),
//    TRAN_BY_MER_ON_CARD(5), USER_PORTFOLIO_SIZE(5), AGENT_ENRLMNT(6), LATE_FEE_BY_MER(6), FBACK_TXN_BY_MER(6),
//    SALE_BY_MER_ON_CARD(6), CONV_FEE_REV_BY_MER(6), CONV_FEE_BY_MER(6), TID_DEINS_BY_MER(6), IVR_CALL_DIST(6),
//    IVR_CALL_BY_TIME(6), IVR_SR_BY_TYPE(6), SR_BY_SOURCE(6), MAPP_SR_BY_TIME(6), MAPP_SR_BY_TYPE(6),
//    WEB_SR_BY_TIME(6), WEB_SR_BY_TYPE(6), ADDITIONAL_TERMINALS(6), DUPLICATE_STATEMENT(6),
//    DUPLICATE_PAYMENT_ADVICE(6), RECON_ISSUE(6), TXNS_VOL(6), REV_OF_R150(6), REV_OF_R200(6), REV_OF_R250(6),
//    REV_OF_R300(6), MERCHANT_ENRLMENT_CHANNEL_ALLIANCEUSER(6), MERCHANT_ENRLMENT_CHANNEL_MERCHANTWEB(6),
//    MERCHANT_ENRLMENT_CHANNEL_MERCHANTAPP(6), MERCHANT_ENRLMENT_CHANNEL_BANKAPP(6),
//    MERCHANT_ENRLMENT_CHANNEL_BANKPORTAL(6), MERCHANT_ENRLMENT_TERMINAL_PSTN(6), MERCHANT_ENRLMENT_TERMINAL_GPRS(6),
//    MERCHANT_ENRLMENT_TERMINAL_MVISA(6), MERCHANT_ENRLMENT_TERMINAL_MMC(6), MERCHANT_ENRLMENT_TERMINAL_MRUPAY(6),
//    MERCHANT_ENRLMENT_TERMINAL_INTERNET(6), MERCHANT_ENRLMENT_TERMINAL_PCPOS(6), MERCHANT_ENRLMENT_TERMINAL_MPOS(6),
//    MERCHANT_ENRLMENT_TERMINAL_CONTACTLESS(6), RATEREVISION_SR_RECEIVED(6), RATEREVISION_SR_APPROVED(6),
//    RATEREVISION_SR_REJECTED(6), RATEREVISION_SR_CLOSED(6), MER_APP_UW_RESUBMITTED_TOT(6),
//    MER_APP_UW_RESUBMITTED_APPROVE(6), MER_APP_UW_RESUBMITTED_REJECT(6), ADDITIONAL_TERMINAL_SR_RECEIVED(6),
//    ADDITIONAL_TERMINAL_SR_APPROVED(6), ADDITIONA_TERMINALL_SR_REJECTED(6), ADDITIONAL_TERMINAL_SR_CLOSED(6),
//    TERMINAL_INSTALLATION_TOT(6), TERMINAL_INSTALLATION_CLOSED(6), TERMINAL_INSTALLATION_INPROGRESS(6),
//    TERMINAL_INSTALLATION_SLACROSSED(6), USER_ACTIVE_QUEUE(6), REVERSAL_BY_MER_ON_CARD(6),
//    TRAN_INACTIVE_MER_ON_CARD(6), DISPUTES_BY_MER_ON_CARD(6), TXNS_BY_MER(6), ONBOARDING_SUCCESSFUL(6),
//    SALES_BY_MER_ON_CARD(6), DISPUTES_ON_MER(6), SALE_BY_TID_ON_CARD(6), LFEE_BY_MER(6), SUP_FEE_REV_BY_MER(6),
//    SUP_FEE_BY_MER(6), ADMIN_FEE_REV_BY_MER(6), ADMIN_FEE_BY_MER(6), RENT_FEE_REV_BY_MER(6), RENT_FEE_BY_MER(6),
//    FBACK_FEE_REV_BY_MER(6), FBACK_FEE_BY_MER(6), LFEE_REV_BY_MER(6), CUST_CASE_BY_RES_STS(6), DISPUTE_OUST(6),
//    DISPUTE_RESOLVED(6), RECOVERY_DISPUTED_AMOUNT(6), FRAUD_DISPUTE_OUST(6), FRAUD_DISPUTE_RECOVERED(6),
//    FRAUD_DISPUTE_WRITTEN(6), PROFILE_BY_PRICE(6), NEW_MER_ACQ_BY_STS(6), REV_OF_R50(6), REV_OF_R100(6),
//    MERCHANT_RECOVERY(6), MC_CHARGEBACK(6), MC_RESOLUTIONS(6), MC_RECOVERIES(6), MER_BY_PROD(6), MER_ENROLLMENT(6),
//    ADDITIONAL_TERMINAL(6), TERMINAL_DEINSTALLATION(6), MERCHANT_DEINSTALLATION(6), CONSUMABLES(6),
//    TERMINAL_BREAKDOWN(6), DUPLICATE_PA(6), PAYMENT_INQUIRY(6), CHARGEBACK_INQUIRY(6), CONTACT_DETAILS_UPDATE(6),
//    NEW_MERCHANT(6), TALK_TO_RM(6), RECONISSUE(6), REQUEST_SEGGREGATION(6), MID_DEINS(6), TID_INS_BY_MER(6),
//    ADDITIONAL_TERMINALS_BY_IVR(6), TERMINAL_DEINSTALLATION_BY_IVR(6), TERMINAL_BREAKDOWN_BY_IVR(6),
//    CONSUMABLES_BY_IVR(6), TALK_TO_RM_BY_IVR(6), CHBK_INQUIRY_BY_IVR(6), PAYMENT_INQUIRY_BY_IVR(6),
//    RECON_ISSUE_BY_IVR(6), NEW_MERCHANT_BY_IVR(6), DUPLICATE_PA_BY_IVR(6), ADDITIONAL_TERMINALS_BY_MAPP(6),
//    TERMINAL_DEINSTALLATION_BY_MAPP(6), TERMINAL_BREAKDOWN_BY_MAPP(6), CONSUMABLES_BY_MAPP(6),
//    TALK_TO_RM_BY_MAPP(6), CHBK_INQUIRY_BY_MAPP(6), PAYMENT_INQUIRY_BY_MAPP(6), RECON_ISSUE_BY_MAPP(6),
//    NEW_MERCHANT_BY_MAPP(6), DUPLICATE_PA_BY_MAPP(6), ADDITIONAL_TERMINALS_BY_WEB(6),
//    TERMINAL_DEINSTALLATION_BY_WEB(6), TERMINAL_BREAKDOWN_BY_WEB(6), CONSUMABLES_BY_WEB(6), TALK_TO_RM_BY_WEB(6),
//    CHBK_INQUIRY_BY_WEB(6), PAYMENT_INQUIRY_BY_WEB(6), RECON_ISSUE_BY_WEB(6), NEW_MERCHANT_BY_WEB(6),
//    DUPLICATE_PA_BY_WEB(6), SR_BY_IVR(6), SR_BY_MAPP(6), SR_BY_WEB(6), APP_INSTALLS(6), APP_UNINSTALLS(6),
//    APP_RATING_5(6), APP_RATING_4(6), APP_RATING_3(6), APP_RATING_2(6), APP_RATING_1(6),
//    RE_SUBMITTED_APPLICATIONS(6), RATE_REVISION(6), PAYMENT_ADVICE_DISTRIBUTION(6), UNDELIVERED_PAYMENT_ADVICE(6),
//    TID_INST_NEW(6), TID_INST_INPROGRESS(6), TID_INST_CLOSED(6), TID_INST_SLA_CROSSED(6), SR_BY_IVR_1208(6),
//    SR_BY_IVR_0804(6), SR_BY_IVR_0412(6), SR_BY_MAPP_1208(6), SR_BY_MAPP_0804(6), SR_BY_MAPP_0412(6),
//    SR_BY_WEB_1208(6), SR_BY_WEB_0804(6), SR_BY_WEB_0412(6), PROVISIONING_REQUEST(6),
//    SERVICING_REQUEST_DISTRIBUTION(6), SERVICING_REQUEST_TYPE(6), SERVICING_REQUEST_BY_SOURCE(6),
//    DIRECT_REPORT_IN_QUEUE(6), DIRECT_REPORT_IN_PROGRESS(6), DIRECT_REPORT_CLOSED(6), UNDERWRITING_NEW(6),
//    UNDERWRITING_REJECTED(6), PA_GEN_CNT(6), PA_DELV_UNDELV(6), PA_UNDELV_BY_REASON(6), ADDITIONAL_TERMINALS_NEW(6),
//    ADDITIONAL_TERMINALS_INPROGRESS(6), ADDITIONAL_TERMINALS_CLOSED(6), ADDITIONAL_TERMINALS_SLA_CROSSED(6),
//    TERMINAL_DEINSTALLATION_NEW(6), TERMINAL_DEINSTALLATION_INPROGRESS(6), TERMINAL_DEINSTALLATION_CLOSED(6),
//    TERMINAL_DEINSTALLATION_SLA_CROSSED(6), TERMINAL_BREAKDOWN_NEW(6), TERMINAL_BREAKDOWN_INPROGRESS(6),
//    TERMINAL_BREAKDOWN_CLOSED(6), TERMINAL_BREAKDOWN_SLA_CROSSED(6), CHBK_INQUIRY_NEW(6),
//    CHBK_INQUIRY_INPROGRESS(6), CHBK_INQUIRY_CLOSED(6), CHBK_INQUIRY_SLA_CROSSED(6), PAYMENT_INQUIRY_NEW(6),
//    PAYMENT_INQUIRY_INPROGRESS(6), PAYMENT_INQUIRY_CLOSED(6), PAYMENT_INQUIRY_SLA_CROSSED(6), DUPLICATE_PA_NEW(6),
//    DUPLICATE_PA_INPROGRESS(6), DUPLICATE_PA_CLOSED(6), DUPLICATE_PA_SLA_CROSSED(6), MATM_DECLINE(6),
//    MATM_CD_DECLINE(6), MATM_CW_DECLINE(6), MATM_BI_DECLINE(6), MATM_CD_APPROVE(6), MATM_CW_APPROVE(6),
//    MATM_BI_APPROVE(6), MATM_APPROVE(6), VPA_PULL_DECLINE(6), VPA_PULL_APPROVE(6), VPA_VERIFY_DECLINE(6),
//    VPA_VERIFY_APPROVE(6), VPA_PUSH_APPROVE(6), VPA_PUSH_DECLINE(6), REVERSAL_PURCHASE(5);
//
//    private int groupId;
//
//    StatisticsEnum(int groupId) {
//        this.groupId = groupId;
//    }
//
//    public int getGroupId() {
//        return groupId;
//    }
//
//}
//
//public enum ActionResponseEnum {
//    REJECT, REFER, APPROVE
//}
//
//public enum BussinessPlaceVerificationEnum {
//    PRIMARYOWNER, OFFICE, HEADOFFICE, HOME, HOMEOWNER// need to removed
//}
//
//public enum TerminalNameEnum {
//    PSTN, GPRS, mVISA, mMC, mRUPAY, INTERNET_GATEWAY, mPOS, PC_POS, CONTACTLESS
//}
//
//public enum TerminalTypeEnum {
//    POS, mPOS, PG, ATM, MICRO_ATM, MOBILE, IVR, PUSH, NONE, ECR, MOTO, TRANSIT;
//}
//
//public enum CityLevelEnum {
//    TIER1, TIER2, TIER3
//}
//
//public enum GenerationOptionEnum {
//    SingleMID_SingleTID, SingleMID_MultipleTID, MultipleMID_MultipleTID
//}
//
//public enum CollateralEnum {
//    Fixed, Deposit, Shares
//}
//
//public enum CrossReferenceEnum {// many(key1) vs one(key2)
//    PINCODE_USER, PRIVILEDGE_USER, DSAUSER_APPLNUM, PRIVILEDGE_CHECKER, ROLE_USER, ROLE_ALLIANCE, ROLE_EXTERNAL,
//    PRIVILEDGE_ALLIANCE, PRIVILEDGE_EXTERNAL, SYSTEMUSER_SYSTEMUSERGROUP, COUNTRY_STATE, COUNTRY_STATE_DISTRICT,
//    DISTRICT_PINCODE
//}
//
//public enum CommonCrossReferenceEnum {
//    COUNTRY_STATE, COUNTRY_STATE_DISTRICT, DISTRICT_PINCODE
//}
//
//public enum ModeEnum {
//    CLIENT, SERVER, WEB
//}
//
//public enum VersionEnum {
//    V1983, V1993, V2003
//}
//
//public enum BitmapEnum {
//    ASCII, BINARY, EBCDIC
//}
//
//public enum LengthEncodingEnum {
//    HEX_2_BYTES, ASCII_4_BYTES, VISA_VIP_2_BYTES, VISA_VIP_4_BYTES,
//}
//
//public enum MerchantChainStatusEnum {
//    INCOMPLETE, ACTIVE, INACTIVE, PURGED, CLOSED
//}
//
//public enum InventoryTypeEnum {
//    CONSUMABLE, PERIPHERAL, NON_PERIPHERAL
//}
//
//public enum CardClassEnum {
//    ALL, PLATINUM, CLASSIC, CONSUMER, PREMIUM, BUSINESS, NA, GOLD, OTHER, COMMERCIAL, SINGNATURE, TRADITIONAL,
//    CORPORATE, INFINITE, STANDARD, TITANIUM, WORLD, B2B
//}
//
//public enum BusinessPlaceFinalOutcomeEnum {
//    RECOMMENDED, NOT_RECOMMENDED, EXCEPTION
//}
//
//public enum TxnAllowedEnum {
//    NOTALLOWED(0), OFFLINE(2), ONLINE(1);
//
//    private int code;
//
//    private TxnAllowedEnum(int code) {
//        this.code = code;
//
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum StatusEnum {
//    INACTIVE, ACTIVE
//}
//
//public enum SaleCriteriaTypeEnum {
//    AMOUNT, COUNTS, AMOUNT_AND_COUNT, AMOUNT_OR_COUNT
//}
//
//public enum TxnLimitMccTypeEnum {
//    HIGH, LOW
//}
//
//public enum SMAllocationMethodEnum {
//    RANDOM, PORTFOLIO
//}
//
//public enum SMCriteriaEnum {
//    PINCODE, CITY, STATE, COUNTRY, NOT_APPLICABLE
//}
//
//public enum TimeFrameTransactionEnum {
//    LAST_MONTH, LAST_THREE_MONTHS, LAST_SIX_MONTHS
//}
//
//public enum RiskCategory {
//    LOW, HIGH, MEDIUM, POTENTIAL_FRAUDULENT
//}
//
//public enum MerchantScreeningEnum {
//    VVERIFICATION_AGAINST_TMF, NEGATIVE_IP_ADDRESS_MATCHING, NEGATIVE_GEOGRAPHY_MATCHING,
//    DISPUTE_HISTORY_VERIFICATION
//
//}
//
//public enum MerchantClassificationEnum {
//    MCC_BASED_RISK_PROFILING, DELIVERY_BILING_CATEGORIZATION, MERCHANT_PAYMENT_CYCLE_CATEGORIZATION
//
//}
//
//public enum MerchantSiteVerification {
//    WEB_CRAWLING_REPORT
//}
//
//public enum MerchantCreditWorthiness {
//    CREDIT_SCORE_AND_BUREAU_RATING, KYC_FULLFILLMENT, OVERALL_ASSESSMENT
//}
//
//public enum VisitFrequencyEnum {
//    MONTHLY, QUARTERLY, HALFYEARLY, YEARLY
//
//}
//
//public enum StatusChangeOperatorEnum {
//    SYS
//}
//
//public enum StatusChangeReasonEnum {
//    NEW
//}
//
//public enum TerminalStatusEnum {
//    NEW, INSTALLED, ACTIVE, BLOCKED, INACTIVE, DE_INSTALLED, DORMANT, CLOSED
//}
//
//public enum StatementSendAddress {
//    FIRST_OWNER_ADDRESS, SECOND_OWNER_ADDRESS, ESTABLISHMENT_ADDRESS, REGISTERED_ADDRESS, WAREHOUSE_ADDRESS
//}
//
//public enum SchemeMsgTypeEnum {
//    PURCHASE, PURCHASEWITHCASHBACK, PURCHASEWITHEMI, PREAUTHORIZATIONREQUEST, PREAUTHORIZATIONCOMPLETION,
//    POSBALANCEENQUIRY, CASHATPOS, ORIGINALCREDITAUTHORIZATION, REVERSAL, REFUND, LOYALTYREDEMPTION, LOYALTYINQUIRY,
//    NETWORKMANAGEMENT, AUTHORIZATIONADVICE, REVERSALADVICE, IVRREQUEST, ECOMMERCEPURCHASE,
//    ECOMMERCEPURCHASEWITHCASHBACK, ECOMMERCEPURCHASEWITHEMI, ECOMMERCEPREAUTHORIZATIONREQUEST,
//    ECOMMERCEPREAUTHORIZATIONCOMPLETION, ECOMMERCEREVERSAL
//
//}
//
//public enum AuthMessageType {
//    AUTH, PREAUTH, PREAUTHCOMPLETION, REVERSAL, REFUND, ADJUST, ATM, OTPRES, MATM, VPA_VERIFY, VPA_PULL, VPA_PUSH,
//    TXN_STATUS_CHECK
//}
//
//public enum AuthMessageSubType {
//    WITH_EMI, WITH_TIP, WITH_SURCHARGE, WITH_FEE, WITH_CASHBACK, CASHATPOS, ATM_AUTH, BALINQ, NORMAL_AUTH,
//    WITH_MANDATE, CASHDEPOSIT, REV_USER_INITATED, REV_TIMED_OUT, ORIGINAL_CREDIT, CASH_DISBRUSTMENT, ADVICE,
//    CREDENTIAL_ON_FILE, ATM_BALINQ // Need to remove afterward kept only for conversion run
//}
//
//public enum ResponseCodeActionEnum {
//    APPROVE, DECLINE, FULLREVERSAL, CAPTURE, REFER
//}
//
//public enum SwitchResponseCodeEnum {
//    Approved("00"), InvalidMerchant("03"), InvalidAmount("13"), CustomerCancellation("17"), FormatError("30"),
//    TransactionNotPermitTerminal("58"), CardAcceptorContactAcquirer("60"), CardAcceptorCallAcquirer("66"),
//    AcquirerTimeout("68"), CutOffInProcess("90"), ComplianceErrorCodeAcquirer("CA"), Timeout("91"),
//    AcquirerReceivedDE38("22"), PartialReversal("32"), TerminalNotReceiveAACAndTC("E2"),
//    ComplianceErrorAcquirer("CA"), PSPSupportedUPI("UA"), ValidationError("ZD");
//
//    private String code;
//
//    private SwitchResponseCodeEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum ApiErrorMessageEnum {
//
//    Success("000"), MissingParameter("001"), InvalidCommand("002"), AmountError("013"), DeclinedLostCard("041"),
//    DeclinedNoAccount("042"), DeclinedStolenCard("043"), NonSufficientFunds("051"), ExpiredCard("054"),
//    WrongPIN("055"), CardHolderNotAllowed("057"), TerminalNotAllowed("058"), Fraud("059"), ContactAcquirer("060"),
//    ExceedsDailyLimit("061"), RestrictedCard("062"), ExceedsFrequency("065"), ErrorIssuerTimeout("091"),
//    NoRoutingAvailable("092"), SystemError("096"), NoAcct("110"), AccountClosed("120"), SystemUnavailable("399"),
//    GeneralError("400"), CommandNullOrEmpty("401"), XMLNullOrEmpty("402"), NotAuthenticated("406"),
//    NotAuthorized("407"), XMLDataError("408"), InvalidBIN("410"), IssuerAuthenticationFailure("412");
//
//    private String code;
//
//    private ApiErrorMessageEnum(String code) {
//        this.code = code;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum StateCodeEnum {
//    Alabama("AL", "Alabama"), Alaska("AK", "Alaska"), Arizona("AZ", "Arizona"),
//    American_Samoa("AS", "American Samoa"), Arkansas("AR", "Arkansas"), California("CA", "California"),
//    Colorado("CO", "Colorado"), Connecticut("CT", "Connecticut"), Deleware("DE", "Delaware"),
//    District_Of_Columbia("DC", "District of Columbia"),
//    Federated_States_Of_Micronesia("FM", "Federated States Of Micronesia"), Florida("FL", "Florida"),
//    Georgia("GA", "Georgia"), Guam("GU", "Guam"), Hawali("HI", "Hawaii"), Idaho("ID", "Idaho"),
//    Illinois("IL", "Illinois"), Indiana("IN", "Indiana"), Iowa("IA", "Iowa"), Kansas("KS", "Kansas"),
//    Kentucky("KY", "Kentucky"), Louisana("LA", "Louisiana"), Maine("ME", "Maine"),
//    Marshall_Islands("MH", "Marshall Islands"), Maryland("MD", "Maryland"), Massachusetts("MA", "Massachusetts"),
//    Michigan("MI", "Michigan"), Minnesota("MN", "Minnesota"), Mississippi("MS", "Mississippi"),
//    Missouri("MO", "Missouri"), Montana("MT", "Montana"), Nebraska("NE", "Nebraska"), Nevada("NV", "Nevada"),
//    New_Hampshire("NH", "New Hampshire"), New_Jersey("NJ", "New Jersey"), New_Mexico("NM", "New Mexico"),
//    New_York("NY", "New York"), North_Carolina("NC", "North Carolina"), North_Dakota("ND", "North Dakota"),
//    Northern_Mariana_Islands("MP", "Northern Mariana Islands"), Ohio("OH", "Ohio"), Oklahoma("OK", "Oklahoma"),
//    Oregon("OR", "Oregon"), Palau("PW", "Palau"), Pennsylvania("PA", "Pennsylvania"),
//    Puerto_Rico("PR", "Puerto Rico"), Rhode_Island("RI", "Rhode Island"), South_Carolina("SC", "South Carolina"),
//    South_Dakota("SD", "South Dakota"), Tennessee("TN", "Tennessee"), Texas("TX", "Texas"), Utah("UT", "Utah"),
//    Vermont("VT", "Vermont"), Virgin_Islands("VI", "Virgin Islands"), Virginia("VA", "Virginia"),
//    Washington("WA", "Washington"), West_Virginia("WV", "West Virginia"), Wisconsin("WI", "Wisconsin"),
//    Wyoming("WY", "Wyoming");
//
//    private String code;
//    private String description;
//
//    private StateCodeEnum(String code, String description) {
//        this.code = code;
//        this.description = description;
//
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//}
//
//public enum ReasonCodeEnum {
//    Authorized_01_01("01", "01", "01_Initial Authorization"), Authorized_01_02("01", "02", "02_Reinstated"),
//    Withdrawn_03_01("03", "01", " 01_Voluntary Withdrawal"), Withdrawn_03_02("03", "02", "02_Involuntary – Other"),
//    Withdrawn_03_03("03", "03", " 03_Involuntary - Withdrawn"),
//    Withdrawn_03_04("03", "04", "04_Involuntary – Does not meet Criteria A or Criteria B"),
//    Withdrawn_03_05("03", "05", "05_Involuntary – Not a Retail Food Store"),
//    Withdrawn_03_06("03", "06", " 06_Involuntary – Failure to Cooperate"),
//    Withdrawn_03_07("03", "07", " 07_Involuntary – Failure to Pay"),
//    Withdrawn_03_08("03", "08", "08_Involuntary – Business Integrity"),
//    Withdrawn_03_09("03", "09", " 09_Involuntary – Non-Redeemer"),
//    Withdrawn_03_10("03", "10*", " 10*_Involuntary – No State Contract*"),
//    Withdrawn_03_11("03", "11", "11_Involuntary – Failure to Cooperate with Reauthorization Process"),
//    Disqualified_04_01("04", "01", "01_SNAP Violation"), Disqualified_04_02("04", "02", "02_WIC Program Violation"),
//    Disqualified_04_03("04", "03", " 03_Failure to Pay"),
//    Permanently_Disqualified_07_01("07", "01", "01_SNAP Violation"),
//    Permanently_Disqualified_07_02("07", "02", "02_WIC Program Violation"),
//    Permanently_Disqualified_07_03("07", "03", "03_Failure to Pay"),
//    Permanently_Withdrawn_10_01("10", "01", "01_Business Integrity");
//
//    private String description;
//    private String code;
//    private String subCode;
//
//    ReasonCodeEnum(String code, String subCode, String description) {
//        this.code = code;
//        this.description = description;
//        this.subCode = subCode;
//
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getsubCode() {
//        return subCode;
//    }
//
//    public static ReasonCodeEnum getByCode(String authorizationStatusCode, String statusReasonCode) {
//        for (ReasonCodeEnum reason : values()) {
//            if (reason.getCode().equals(authorizationStatusCode) && reason.getsubCode().equals(statusReasonCode)) {
//                return reason;
//
//            }
//        }
//        return null;
//    }
//
//}
//
//public enum PanEntryModeEnum {
//    PAN_ENTRY_UNKNOWN(00), MANUAL(1), MAGNETIC_STRIP_READ(2), BARCOD_READER(3), OPTICAL_CARD_READER(4), ICC(5),
//    IVR(6), CONTACTLESS_PAYMENT_CHIP(7), QR_CODE(8), NFC(9), BLUETOOTH_LOW_ENERGY(10), FALLBACK_TRANSACTION(80),
//    E_COMMERCE(81), FULL_UNALTERED_MAGNETICSTRIP(90), CONTACTLESS_CVD_iCVD(91), CHIP_UNRELIABLE_CVD_iCVD(95),
//    RESERVED_RUPAY(99);
//
//    private int code;
//
//    private PanEntryModeEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//
//}
//
//public enum PinCaptureRupayEnum {
//    NO_PIN(0), CHAR4(1), CHAR5(2), CHAR6(3), CHAR7(4), CHAR8(5), CHAR9(6), CHAR10(7), CHAR11(8), CHAR12(9);
//
//    private int code;
//
//    private PinCaptureRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum PinCapEnum {
//    UNSPECIFIED(0), PIN_ENTRY_CAPABILITY(1), NO_PIN_ENTRY_CAPABILITY(2), PIN_PAD_INOPERATIVE(6), RESERVED_RUPAY(8),
//    RESERVED_PRIVATE_USE_BIOMETRIC(9);
//
//    private int code;
//
//    private PinCapEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum PosConditionCodeEnum {
//    NORMAL(00), CUSTOMER_NOT_PRESENT(1), UNATTENDED_TERMINAL(2), MERCHANT_SUSPICIOUS(3),
//    CUSTOMER_PRESENT_CARD_NOTPRESENT(5), TELEPHONE_REQUEST(7), MO_TO_REQUEST(8),
//    REQUEST_ACCOUNT_CVD_VERIFICATION_WITHOUT_AUTH(51), E_COMMERCE_REQUEST(59),
//    CARD_PRESENT_MAGNETICSTRIP_NO_READ(71);
//
//    private int code;
//
//    private PosConditionCodeEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum RejectReasonEnum {
//    AMTI, A002, A003, A004, A005, A006, A007, A011, A012, A013, A014, A018, A019, A022, A023, A025, A032, A033,
//    A035, A037, A038, A040, A041, A042, A043, A044, A045, A048, A049, A052, A054, A055, A061, A063, A090, A095,
//    A104, A126, A127, A195, A196, A197, A198, A199, I003, I004, I006, I007, I012, I013, I014, I019, I022, I023,
//    I025, I035, I038, I039, I045, I048, I049, I051, I052, I054, I055, I061, I063, I090, I104, I196, I197, I198,
//    I199, UB, UC, UD, UE, UF, UG, UH, UI, UJ, UK, UL, UM, UN, UO, UP, UQ, UR, US, UT, UU, UV, UY, UZ, U0, U1, U2,
//    U3, U4, U5, U6, U7, U8, U9, VA, VB, VC, VD, VE, VF, VG, VH, VI, VJ, VK, VL, VM, VN, VO, VP, VQ, VR, VS, VT, VU,
//    VV, VW, VX, VY, VZ, V0, V1, V2, V3, V4, V5, V6, V7, V8, V9, W0, W1, W2, W3, W4, W5, W6, W7, W8, W9, WA, X0, X1,
//    X2, X3, X4, X5, X6, X7, X8, X9, UX, UW, M4, M6
//}
//
//public enum CardDataInputCapabilityRupayEnum {
//    UNKNOWN(0), MAGNETICSTRIPE_READ_CAP(1), ICC_CAP(2), MAGNETICSTRIPE_KEYENTRY_CAP(3), MAGNETICSTRIPE_ICC_CAP(4),
//    MANUAL_NOTERMINAL(5), KEY_ENTERED(6), CONTACLESS_ONLY(7), MAGNETICSTRIPE_ICC_CONTACTLESS_CAP(8);
//
//    private int code;
//
//    private CardDataInputCapabilityRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum CardAuthCapabilityRupayEnum {
//    UNKNOWN(0), AUTH_METHOD_OTHERTHAN_PIN_BIO(1), PIN_ENTRY(2), BIOMETRIC(3);
//
//    private int code;
//
//    private CardAuthCapabilityRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum CardCaptureRupayEnum {
//    UNKNOWN(0), NO_CAPTURE(1), CAPTURE(2);
//
//    private int code;
//
//    private CardCaptureRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum TerminalOperEnvRupayEnum {
//    UNKNOWN("0"), ON_PREMISIS_ACCEPTOR_ATTENDED("1"), ON_ACCEPTOR_PREMISIS_UNATTENDED("2"),
//    OFF_PREMISIS_ACCEPTOR_ATTENDED("3"), OFF_PREMISIS_ACCEPTOR_UNATTENDED("4"),
//    ON_PREMISIS_CARDHOLDER_UNATTENDED("5"), NO_TERMINAL("6"), ON_PREMISIS_ACCEPTOR_ATTENDED_MPOS("7"),
//    ON_ACCEPTOR_PREMISIS_UNATTENDED_MPOS("8"), OFF_PREMISIS_ACCEPTOR_ATTENDED_MPOS("9"),
//    OFF_PREMISIS_ACCEPTOR_UNATTENDED_MPOS("A"), ON_PREMISIS_CARDHOLDER_UNATTENDED_MPOS("B"), DOLLAR_TERMINAL("C"),
//    DOLLAR_MPOS_TERMINAL("D");
//
//    private String code;
//
//    private TerminalOperEnvRupayEnum(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//}
//
//public enum CardHolderPresentRupayEnum {
//    UNKNOWN(0), CARDHOLDER_PRESENT(1), CARDHOLDER_NOT_PRESENT_UNSPECIFIED_REASON(2),
//    CARDHOLDER_NOT_PRESENT_MAIL_TRANSACTION(3), CARDHOLDER_NOT_PRESENT_TELEPHONE_TRANSACTION(4),
//    CARDHOLDER_NOT_PRESENT_STANDING_INSTRUCTION(5), E_COMMERCE_TRANSACTION(6), IVR_TRANSACTION(7),
//    RECURRING_PAYMENT(8);
//
//    private int code;
//
//    private CardHolderPresentRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum CardPresentRupayEnum {
//    UNKNOWN(0), CARD_PRESENT(1), CARD_NOT_PRESENT(2);
//
//    private int code;
//
//    private CardPresentRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum CardDataInputRupayEnum {
//    UNKNOWN(0), MANUAL_NO_TERMINAL(1), MAGNETIC_STRIP_READ(2), ONLINE_CONTACT_CHIP(3), OFFLINE_CONTACTLESS(4),
//    ECOMMERCE(5), IVR(6), KEY_ENTERTED(7);
//
//    private int code;
//
//    private CardDataInputRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum CardHolderAuthRupayEnum {
//    UNKNOWN("0"), NOT_AUTHENTICATED("1"), PIN("2"), SIGNATURE("3"), BIOMETRIC_FMR("4"), OTP("5"),
//    E_COMMERCE_TYPE1_PIN("6"), E_COMMERCE_TYPE1_OTP("7"), E_COMMERCE_TYPE2("8"), IVR_TYPE1("9"), BIOMETRIC_FIR("A"),
//    BIOMETRIC_IIR("B"), BIOMETRIC_PIN("C"), BIOMETRIC_OTP("D"), BIOMETRIC_FIR_FMR_IIR_WITH_PIN("E"),
//    BIOMETRIC_FIR_FMR_IIR_WITH_OTP("F"), AUTHENTICATED_WITH_OTP("G");
//
//    private String code;
//
//    private CardHolderAuthRupayEnum(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//}
//
//public enum CardHolderAuthEntityRupayEnum {
//    UNKNOWN("0"), ICC("1"), CAD("2"), TYPE1("A"), TYPE3("C"), TYPE4("D"), TYPE2("I");
//
//    private String code;
//
//    private CardHolderAuthEntityRupayEnum(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//}
//
//public enum CardDataOutputRupayEnum {
//    UNKNOWN(0), MAGNETICSTRIPE_WRITE(1), ICC_WRITE(2);
//
//    private int code;
//
//    private CardDataOutputRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum TerminalDataOutputRupayEnum {
//    UNKNOWN(0), PRINT(1), DISPLAY(2), PRINT_DISPLAY(3);
//
//    private int code;
//
//    private TerminalDataOutputRupayEnum(int code) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//}
//
//public enum CommunicationTemplateEnum {
//    SMS, EMAIL, BANNER, WA, NOTIFICATION, LETTER
//}
//
//public enum SwitchMessageTypeEnum {
//    SMS, DMS
//}
//
//public enum SettlementStatusEnum {
//    NOT_SETTLED, SETTLED, DISPUTED, RE_SETTLED, ARBITRATION, SCHEME_REJECT
//}
//
//public enum CommunicationRecipientsEnum {
//    MERCHANT, SM
//}
//
//public enum FieldsEnum {
//    OPERATION_START_TIME, OPERATION_CLOSE_TIME, WEBSITE_ADDRESS, URL, FAILURE_URL, TRANSACTION_MODE, CERTIFICATION,
//    INTERFACE_LANGUAGE, APPLICATION_DEVELOPMENT, SETTLEMENT_CURRENCY, MERCHANT_TYPE, MERCHANT_SEGMENT,
//    MERCHANT_PRIORITY, BUSINESS_ENTITY, NATURE_OF_BUSINESS, IS_WHATSAPP, IS_BANNER, IS_SMS, IS_EMAIL,
//    IS_NOTIFICATION, ACCOUNT_PAYMENT_MODE, DEBIT_ACCOUNT_PAYMENT_MODE, MERCHANT_PROFILE, STM_FREQUENCY, STM_MODE,
//    SEND_STM, STM_TYPE, STM_LEVEL // tobeRemoved
//
//}
//
//public enum ProcessingStatusEnum {
//    SAVED, SUBMITTED, ASSIGNED_SM, DOCUMENT_CHECK_IS_IN_PROGRESS, DOCUMENT_CHECK_SUCCESSFULL, INSUFFICIENT_DOCS,
//    DUPLICATE_CHECK_IN_PROGRESS, DUPLICATE_UNSUCCESSFUL, FRAUD_CHECK_IN_PROGRESS, MERCHANT_FOUND_IN_FRAUD,
//    BANKCARD_TERMINATED_CHECK_IN_PROGRESS, FOUND_IN_TMF, FAST_TRACK_CRITERIA_EVALUATION, FAST_TRACK_APPROVED,
//    FAST_TRACK_INTERNAL_APPROVED, END_FAST_TRACK_APPROVED, ACCEPTANCE_REVIEW_IN_PROGRESS,
//    ACCEPTANCE_REVIEW_REJECTED, CREDIT_BUREAU_INQUIRY_IN_PROGRESS, CREDIT_BUREAU_INQUIRY_REJECTED,
//    BUSINESS_APPROVAL_IN_PROGRESS, BUSINESS_APPROVAL_REJECTED, DOCUMENT_EVALUATION_IN_PROGRESS,
//    DOCUMENT_EVALUATION_FAILED, WEBSITE_AUTHENTICATION_IN_PROGRESS, WEBSITE_AUTHENTICATION_FAILED,
//    UNDER_WRITING_IN_PROGRESS, UNDER_WRITING_FAILED, SELECTED_RANGE_REQUIRED, MERCHANT_SUCCESSFULLY_BOARDED,
//    MERCHANT_MASTER_IN_PROGRESS, IN_DISCUSSION, IN_PROGRESS, BLACKLISTED_PINCODE_REJECTED,
//    BLACKLISTED_PINCODE_SUCCESSFULL, DUPLICATE_CHECK_SUCCESSFULL, FRAUD_CHECK_SUCCESSFULL, REJECT_FILE_APPROVED,
//    FOUND_IN_REJECT, TMF_SUCCESSFULL, PREAPPROVAL_SUCCESSFULL, CREDIT_BUREAU_SUCCESSFULL, FIRST_CUSTOM_SUCCESSFULL,
//    SECOND_CUSTOM_SUCCESSFULL, THIRD_CUSTOM_SUCCESSFULL, BUSINESS_APPROVAL_SUCCESSFULL, DOC_EVALUATION_SUCCESSFULL,
//    WEBSITE_AUTHENTICATION_SUCCESSFULL, CHECK_CPV_SUCCESSFULL, CHECK_CPV_IN_PROGRESS, UNDER_WRITING_SUCCESSFULL,
//    DOCUMENT_CHECK_UNSUCCESSFULL, REJECT_CHECK_IN_PROGRESS, TMF_IN_PROGRESS, FAST_TRACK_REJECTED,
//    PREAPPROVAL_UNSUCCESSFULL, PREAPPROVAL_IN_PROGRESS, FIRST_CUSTOM_UNSUCCESSFULL, FIRST_CUSTOM_IN_PROGRESS,
//    SECOND_CUSTOM_UNSUCCESSFULL, SECOND_CUSTOM_IN_PROGRESS, THIRD_CUSTOM_UNSUCCESSFULL, THIRD_CUSTOM_IN_PROGRESS,
//    CHECK_CPV_UNSUCCESSFULL, BUISNESS_PLACE_CHECK_SUCCESSFULL, BUISNESS_PLACE_CHECK_IN_PROGRESS,
//    BUISNESS_PLACE_CHECK_REJECTED, P4_CUSTOM_SUCCESSFULL, P5_CUSTOM_SUCCESSFULL, P6_CUSTOM_SUCCESSFULL,
//    P7_CUSTOM_SUCCESSFULL, P8_CUSTOM_SUCCESSFULL, P9_CUSTOM_SUCCESSFULL, P10_CUSTOM_SUCCESSFULL,
//    P11_CUSTOM_SUCCESSFULL, P12_CUSTOM_SUCCESSFULL, P13_CUSTOM_SUCCESSFULL, P14_CUSTOM_SUCCESSFULL,
//    P15_CUSTOM_SUCCESSFULL, P16_CUSTOM_SUCCESSFULL, P17_CUSTOM_SUCCESSFULL, P18_CUSTOM_SUCCESSFULL,
//    P4_CUSTOM_UNSUCCESSFULL, P5_CUSTOM_UNSUCCESSFULL, P6_CUSTOM_UNSUCCESSFULL, P7_CUSTOM_UNSUCCESSFULL,
//    P8_CUSTOM_UNSUCCESSFULL, P9_CUSTOM_UNSUCCESSFULL, P10_CUSTOM_UNSUCCESSFULL, P11_CUSTOM_UNSUCCESSFULL,
//    P12_CUSTOM_UNSUCCESSFULL, P13_CUSTOM_UNSUCCESSFULL, P14_CUSTOM_UNSUCCESSFULL, P15_CUSTOM_UNSUCCESSFULL,
//    P16_CUSTOM_UNSUCCESSFULL, P17_CUSTOM_UNSUCCESSFULL, P18_CUSTOM_UNSUCCESSFULL, P4_CUSTOM_IN_PROGRESS,
//    P5_CUSTOM_IN_PROGRESS, P6_CUSTOM_IN_PROGRESS, P7_CUSTOM_IN_PROGRESS, P8_CUSTOM_IN_PROGRESS,
//    P9_CUSTOM_IN_PROGRESS, P10_CUSTOM_IN_PROGRESS, P11_CUSTOM_IN_PROGRESS, P12_CUSTOM_IN_PROGRESS,
//    P13_CUSTOM_IN_PROGRESS, P14_CUSTOM_IN_PROGRESS, P15_CUSTOM_IN_PROGRESS, P16_CUSTOM_IN_PROGRESS,
//    P17_CUSTOM_IN_PROGRESS, P18_CUSTOM_IN_PROGRESS, PRICING_APPROVE_SUCCESSFULL, PRICING_APPROVE_UNSUCCESSFULL,
//    PRICING_APPROVE_IS_IN_PROGRESS, ONBOARDING_SEARCH_UNSUCCESSFULL, DUPLICATE_PREFERRED_MERCHANT_NUMBER;
//
//    // need to be
//    // removed
//}
//
//public enum TerminalFeaturesEnum {
//    CONTACTLESS, EMI, LOYALTY, NONE
//}
//
//public enum DashBoardAccessEnum {
//    NONE, SALES_AND_MARKETING, UNDERWRITING, MERCHANT_ONBOARDING, CUSTOMER_SERVICE_MANAGER, SAM, CSM, OMD, UWD, DMD,
//    LEGAL, RISK, FINANCE
//}
//
//public enum ActiveABEnum {
//    A, B
//}
//
//public enum InventoryNameEnum {
//    PSTN, GPRS, mVISA, mMC, mRUPAY, INTERNET_GATEWAY, mPOS, PC_POS, CONTACTLESS, REPLACEMENT_BATTERIES,
//    TERMINAL_CABLE, INK_CARTRIDGE, PRINTER_ATTACHMENT, SIM, LARGE_HIGH_PAPERROLL, MEDIUM_HIGH_PAPERROLL,
//    SMALL_HIGH_PAPERROLL, LARGE_MEDIUM_PAPERROLL, MEDIUM_MEDIUM_PAPERROLL, SMALL_MEDIUM_PAPERROLL, CHARGER
//}
//
//public enum SchemeFraudReasonEnum {
//    VISA_83
//}
//
//public enum DisputeTypeEnum {
//    CHARGEBACKS, PRE_ARBITRATION, ARBITRATION, PRE_COMPLAINCE, COMPLAINCE, CASES, RECOVERED, PENDING, PENDING_GT_30,
//    RETRIEVAL_REQUEST, OMBUDSMAN, CONSUMER_COURT, CIVIL_COURT, REFUND_CHARGEBACK, RETRIEVAL_REQUEST_NOTFULFILLMENT,
//    RETRIEVAL_REQUEST_FULFILLMENT, CHARGEBACK_ACCEPTANCE, RE_PRESENTMENT, RE_PRESENTMENT_ACCEPTANCE,
//    PRE_COMPLIANCE_ACCEPTANCE, COMPLIANCE_ACCEPTANCE, PRE_ARBITRATION_ACCEPTANCE, ARBITRATION_ACCEPTANCE,
//    GOOD_FAITH, GOOD_FAITH_ACCEPTANCE, Chargeback_Deemed_Acceptance, Pre_Arbitration_Deemed_Acceptance,
//    FIRST_CHARGEBACK, ARBITRATION_CHARGEBACK, SECOND_CHARGEBACK, RETRIEVAL_REQUEST_ACKNOWLEDGMENT,
//    SECOND_PRESENTMENT, FEE_COLLECTION
//}
//
//public enum pre_arbitrationEnum {
//    ACCEPTED, DECLINED
//}
//
//public enum DisputeSourceEnum {
//    OMBUDSMAN, CONSUMER_COURT, CIVIL_COURT, VISA, MC, RUPAY, AMEX, DISCOVER, DINERS, UPI_NPCI, CHINAUNIONPAY, NCCC,
//    IBANKING, WALLETS, PAYzAPP, BHARATPE, ALL, NA, ONUS, NETWORK, OUTSTANDING;// needs to be removed
//    // OUTSTANDING, TOTAL_CASES, RECOVERED, WRITTEN_OFF
//}
//
//public enum DisputeStageEnum {
//    OPEN, CLOSE, ACCEPTED, REJECTED, RR_ACCEPTED, RR_REJECTED, CB_ACCEPTED, CB_REJECTED
//}
//
//public enum TxnStatusEnum {
//    HOLD, NON_HOLD, REVERSAL, SETTLEMENT, REJECT, DISPUTE
//}
//
//public enum paymentMethodTypeEnum {
//    REALTIME, NON_REALTIME
//}
//public enum SRDisputeEnum {
//    CANCEL, CLOSED
//}
//
//public enum FeaturesSupportedEnum {
//    CONTACTLESS, EMI, LOYALTY, DCC, DUAL_SIM, MULTICURRENCY, MULTISETTLEMENT, NONE
//}
//
//public enum InternalExternalEnum {
//    INTERNAL, EXTERNAL
//}
//
//public enum PaymentLevelEnum {
//    CHAIN_LEVEL, MERCHANT_LEVEL
//}
//
//public enum UnderwritingStatsEnum {
//    TOTAL_APPS, APPROVED, REJECTED, IN_PROGRESS, POS, PG, BOTH
//}
//
//public enum PrefixFolder {
//
//    PRODUCT_INVENTORY("png, jpeg, jpg, svg"),
//    MERCHANT_APPLICATION("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf, ppt, pptx, txt, csv"),
//    APPLICATIONLEAD("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf, ppt, pptx, txt, csv"),
//    MERCHANT_DOMAIN("png, jpeg, jpg, pdf, svg"), REPORTS("png, jpeg, jpg, svg"),
//    SYSTEM_USER("png, jpeg, jpg, svg, csv"), ALLIANCE_USER("png, jpeg, jpg, svg"),
//    EXTERNAL_USER("png, jpeg, jpg, svg"), output("png, jpeg, jpg, svg, pdf, csv"),
//
//    SERVICE_REQUEST("png, jpeg, jpg, doc, xls, docx, xlsx, pdf, ppt, pptx, zip, 7z , txt, csv"),
//    input("png, jpeg, jpg, svg, pdf"), OFFERS("png, jpeg, jpg, svg"), PAYMENT_PAGE_LOGO("png, jpeg, jpg, svg"),
//    ACQUIRER("png, jpeg, jpg, svg"),
//    ALLAINCE_ORG("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf , ppt, pptx , txt, csv"),
//    TEMP_DIR("png, jpeg, jpg, svg, doc, xls, docx, xlsx, pdf, ppt, pptx, txt, csv"),
//    INCOMING_EMAIL("png, jpeg, jpg, svg"), MERCHANT_PROFILE("docx, xlsx"), FILE_UPLOAD_REQUEST("csv"),
//    DATA_DOWNLOAD("csv"), PAY_INSTRUMENT_FACEID("png, jpeg, jpg"), SWITCH_CONTROL_LOGO("png, jpeg, jpg"),
//    SERVICE_DIRECTORY("p12, txt"), PRODUCT_CATALOGUE("png, jpeg, jpg, svg"),
//    DISPUTES("pdf,tiff,jpeg,xls,pgp");
//    private String contentType;
//
//    private PrefixFolder(String contentType) {
//        this.contentType = contentType;
//    }
//
//    public boolean isAllowedContentType(String input, String filename) {
//        String[] typ = this.contentType.split(",");
//        String e = null;
//        switch (input) {
//            case "image/bmp":
//                e = "bmp";
//                break;
//            case "text/csv":
//                e = "csv";
//                break;
//            case "application/msword":
//                e = "doc";
//                break;
//            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
//                e = "docx";
//                break;
//            case "image/jpeg":
//                e = "jpeg";
//                break;
//            case "application/json":
//                e = "json";
//                break;
//            case "application/vnd.oasis.opendocument.text":
//                e = "odt";
//                break;
//            case "image/png":
//                e = "png";
//                break;
//            case "application/pdf":
//                e = "pdf";
//                break;
//            case "application/vnd.ms-powerpoint":
//                e = "ppt";
//                break;
//            case "application/vnd.openxmlformats-officedocument.presentationml.presentation":
//                e = "pptx";
//                break;
//            case "image/svg+xml":
//                e = "svg";
//                break;
//            case "text/plain":
//                e = "txt";
//                break;
//            case "application/vnd.ms-excel":
//                e = "xls";
//                break;
//            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
//                e = "xlsx";
//                break;
//            case "application/zip":
//                e = "zip";
//                break;
//            case "application/x-7z-compressed":
//                e = "7z";
//                break;
//            case "application/tiff":
//                e = "tiff";
//                break;
//            case "image/pgp":
//                e = "pgp";
//                break;
//            case "application/octet-stream":
//                e = "unknown";
//                if (filename != null) {
//                    logger.info("print filename : ".concat(filename));
//                    if (filename.contains(".")) {
//                        e = filename.substring(filename.lastIndexOf(".") + 1);
//                    }
//                }
//                break;
//            case "application/x-pkcs12":
//                e = "p12";
//                break;
//            default:
//                e = "unknown";
//                break;
//        }
//
//        for (String s : typ) {
//            if (s.strip().toLowerCase().equals(e.toLowerCase())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
//
//public enum OperationMangerCount {
//    GENERATED, DELIVERED, UNDELIVERED, MAIL, NO_MAIL
//}
//
//public enum PANEntryMode {
//    VI_PANEntry_10_1("VISA_Ecom_COF", "DE22.1", "10", "MANUAL", "1"),
//    MC_PANEntry_10_1("MC_Manual_No_Terminal", "DE22.1", "10", "MANUAL", "1"),
//    VI_PANEntry_96_1("VISA_Manual_No_Terminal", "DE22.1", "96", "MANUAL", "1"),
//    MC_PANEntry_02_2("MC_PAN_AutoEntry_MagneticStripe_TrackDataNotCaptured", "DE22.1", "02", "MAGNETIC_STRIPE_READ",
//            "2"),
//    VI_PANEntry_02_2("VISA_PAN_AutoEntry_MagneticStripe_TrackDataNotCaptured", "DE22.1", "02",
//            "MAGNETIC_STRIPE_READ", "2"),
//    RP_PANEntry_02_2("RP_PAN_AutoEntry_MagneticStripe_TrackDataNotCaptured", "DE22.1", "02", "MAGNETIC_STRIPE_READ",
//            "2"),
//    MC_PANEntry_01_6("MC_Manual_KeyEntered", "DE22.1", "01", "IVR", "6"),
//    VI_PANEntry_01_6("VISA_Manual_KeyEntered", "DE22.1", "01", "IVR", "6"),
//    RP_PANEntry_01_6("RP_Manual_KeyEntered", "DE22.1", "01", "IVR", "6"),
//    MC_PANEntry_91_A("MC_PAN_AutoEntry_MagneticStripe_Contactless", "DE22.1", "91", "CONTACTLESS_USING_CVD", "A"),
//    VI_PANEntry_91_A("VISA_PAN_AutoEntry_MagneticStripe_Contactless", "DE22.1", "91", "CONTACTLESS_USING_CVD", "A"),
//    RP_PANEntry_91_A("RP_PAN_AutoEntry_MagneticStripe_Contactless", "DE22.1", "91", "CONTACTLESS_USING_CVD", "A"),
//    MC_PANEntry_90_B("MC_PAN_AutoEntry_MagneticStripe_TrackDataCapturedUnaltered", "DE22.1", "90",
//            "MAGNETIC_STRIPE_READ", "B"),
//    VI_PANEntry_90_B("VISA_PAN_AutoEntry_MagneticStripe_TrackDataCapturedUnaltered", "DE22.1", "90",
//            "MAGNETIC_STRIPE_READ", "B"),
//    RP_PANEntry_90_B("RP_PAN_AutoEntry_MagneticStripe_TrackDataCapturedUnaltered", "DE22.1", "90",
//            "MAGNETIC_STRIPE_READ", "B"),
//    MC_PANEntry_05_C("MC_PAN_AutoEntry_Chip", "DE22.1", "05", "CONTACT_CHIP", "C"),
//    VI_PANEntry_05_C("VISA_PAN_AutoEntry_Chip", "DE22.1", "05", "CONTACT_CHIP", "C"),
//    RP_PANEntry_05_C("RP_PAN_AutoEntry_Chip", "DE22.1", "05", "CONTACT_CHIP", "C"),
//    MC_PANEntry_81_S("MC_Electronic_Commerce", "DE22.1", "81", "E_COMMERCE", "S"),
//    VI_PANEntry_01_S("VISA_Electronic_Commerce", "DE22.1", "01", "E_COMMERCE", "S"),
//    RP_PANEntry_81_S("RP_Electronic_Commerce", "DE22.1", "81", "E_COMMERCE", "S"),
//    MC_PANEntry_07_M("MC_PAN_AutoEntry_Chip_Contactless", "DE22.1", "07", "CONTACTLESS_PAYMENT_USING_CHIP_CARD",
//            "M"),
//    VI_PANEntry_07_M("VISA_PAN_AutoEntry_Chip_Contactless", "DE22.1", "07", "CONTACTLESS_PAYMENT_USING_CHIP_CARD",
//            "M"),
//    RP_PANEntry_07_M("RP_PAN_AutoEntry_Chip_Contactless", "DE22.1", "07", "CONTACTLESS_PAYMENT_USING_CHIP_CARD",
//            "M"),
//    MC_PANEntry_00_0("MC_Unspecified, Data Inavailable", "DE22.1", "00", "UNKNOWN", "0"),
//    VI_PANEntry_00_0("VISA_Unspecified", "DE22.1", "00", "UNKNOWN", "0"),
//    RP_PANEntry_00_0("RP_Unspecified", "DE22.1", "00", "UNKNOWN", "0"),
//    MC_PANEntry_03("MC_PAN_AutoEntry_BarCodeReader", "DE22.1", "03", "MANUAL", "?"),
//    VI_PANEntry_03("VISA_PAN_AutoEntry_BarCodeReader", "DE22.1", "03", "MANUAL", "?"),
//    RP_PANEntry_03("RP_PAN_AutoEntry_BarCodeReader", "DE22.1", "03", "MANUAL", "?"),
//    MC_PANEntry_04("MC_PAN_AutoEntry_OpticalCharacterReader", "DE22.1", "04", "MANUAL", "?"),
//    RP_PANEntry_04("RP_PAN_AutoEntry_OpticalCharacterReader", "DE22.1", "04", "MANUAL", "?"),
//    MC_PANEntry_80("MC_Fallback_to_MagneticStripe", "DE22.1", "80", "FALLBACK_TRANSACTIONS", "?"),
//    RP_PANEntry_80("RP_Fallback_to_MagneticStripe", "DE22.1", "80", "FALLBACK_TRANSACTIONS", "?"),
//    MC_PANEntry_01("MC_Manual_IVR", "DE22.1", "01", "IVR", "?"),
//    VI_PANEntry_01("MC_Manual_IVR", "DE22.1", "01", "IVR", "?"),
//    RP_PANEntry_06("RP_Manual_IVR", "DE22.1", "06", "IVR", "?"),
//    RP_PANEntry_08("RP_QR_Code", "DE22.1", "08", "QR_CODE", "?"),
//    RP_PANEntry_09("RP_PAN_AutoEntry_NFC", "DE22.1", "09", "CONTACTLESS_PAYMENT_USING_CHIP_CARD", "?"),
//    RP_PANEntry_10("RP_PAN_AutoEntry_BluetoothLowEnerg", "DE22.1", "10", "CONTACTLESS_PAYMENT_USING_CHIP_CARD",
//            "?"),
//    MC_PANEntry_95("MC_PAN_AutoEntry_Chip_unreliable", "DE22.1", "95", "FALLBACK_TRANSACTIONS", "?"),
//    VI_PANEntry_95("VISA_PAN_AutoEntry_Chip_unreliable", "DE22.1", "95", "FALLBACK_TRANSACTIONS", "?"),
//    RP_PANEntry_95("RP_PAN_AutoEntry_Chip_unreliable", "DE22.1", "95", "FALLBACK_TRANSACTIONS", "?"),
//    MC_PANEntry_79("MC_Fallback_to_ManualVoice", "DE22.1", "79", "Fallback_ManualVoice", "?"),
//    MC_PANEntry_82("MC_PAN_AutoEntry_StoredServer", "DE22.1", "82", "UNKNOWN", "?"),
//    VI_PANEntry_96("VISA_PAN_AutoEntry_StoredServer", "DE22.1", "96", "UNKNOWN", "?"),
//    MC_PANEntry_09_S("MC_PAN_AutoEntry_ECOMDSRP", "DE22.1", "09", "E_COMMERCE", "S"),
//    EBT_PANEntry_00_0("EBT_Unspecified", "DE22.1", "00", "PAN_ENTRY_UNKNOWN", "0"),
//    EBT_PANEntry_01_B("EBT_Manual_KeyEntered", "DE22.1", "01", "MANUAL", "1"),
//    EBT_PANEntry_02_B("EBT_Magstripe_prior_2007", "DE22.1", "02", "MAGNETIC_STRIPE_READ", "B"),
//    EBT_PANEntry_03_3("EBT_Barcode", "DE22.1", "03", "BARCOD_READER", "3"),
//    EBT_PANEntry_04_B("EBT_Magstripe_after_2007", "DE22.1", "04", "MAGNETIC_STRIPE_READ", "B"),
//    EBT_PANEntry_05_5("EBT_ICC_chip", "DE22.1", "05", "ICC", "5"),
//    EBT_PANEntry_06_6("EBT_IVR_Account_on_file", "DE22.1", "06", "IVR", "6"),
//    EBT_PANEntry_70_9("EBT_NFC_RFID", "DE22.1", "70", "NFC", "9"),
//    EBT_PANEntry_90_B("EBT_PAN_AutoEntry_MagneticStripe_TrackDataCapturedUnaltered", "DE22.1", "90",
//            "MAGNETIC_STRIPE_READ", "B");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//    private String description037;
//    private String code;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    public String getDescription037() {
//        return description037;
//    }
//
//    public void setDescription037(String description037) {
//        this.description037 = description037;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    private PANEntryMode(String description, String associatedDE, String deValue, String description037,
//                         String code) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//        this.description037 = description037;
//        this.code = code;
//    }
//}
////
////	public enum MakerCheckerAvailableEnum {
////		BIN_UPD("/api/bin/maker/upd", "BIN", "UPDATE", "Update to BIN Table"),
////		PINCODE_UPD("/api/pincode/maker/upd", "PINCODE", "UPDATE", "Update to Pincode Table"),
////		PROFILE_UPD("/api/merchantProfiling/upd", "MERCHANT_PROFILE", "UPDATE", "Update to Merchant Profile");
////
////		private String apipath;
////		private String model;
////		private String crud;
////		private String description;
////
////		private MakerCheckerAvailableEnum(String apipath, String model, String crud, String description) {
////			this.apipath = apipath;
////			this.model = model;
////			this.crud = crud;
////			this.description = description;
////		}
////
////		public HashMap<String, String> getDetail() {
////			HashMap<String, String> val = new HashMap<String, String>();
////			val.put("apipath", this.apipath);
////			val.put("model", this.model);
////			val.put("crud", this.crud);
////			val.put("description", this.description);
////			val.put("enum", this.name());
////			return val;
////		}
////
////		public String getApipath() {
////			return this.apipath;
////		}
////
////		public String getModel() {
////			return this.model;
////		}
////
////		public String getCrud() {
////			return this.crud;
////		}
////
////		public String getDescription() {
////			return this.description;
////		}
////
////	}
//
//public enum PINEntryCapability {
//    VI_PINEntry_0("VISA_PIN_Entry_Unknown", "DE22.2", 0), MC_PINEntry_0("MC_PIN_Entry_Unknown", "DE22.2", 0),
//    RP_PINEntry_0("RP_PIN_Entry_Unknown", "DE22.2", 0), VI_PINEntry_1("VISA_PIN_Entry_Accepted", "DE22.2", 1),
//    MC_PINEntry_1("MC_PIN_Entry_Accepted", "DE22.2", 1), RP_PINEntry_1("RP_PIN_Entry_Accepted", "DE22.2", 1),
//    VI_PINEntry_2("VISA_PIN_Entry_CannotAccept", "DE22.2", 2),
//    MC_PINEntry_2("MC_PIN_Entry_CannotAccept", "DE22.2", 2),
//    RP_PINEntry_2("RP_PIN_Entry_CannotAccept", "DE22.2", 2),
//
//    VI_PINEntry_3("VISA_PIN_Entry_CannotAccept", "DE22.2", 3),
//    MC_PINEntry_3("MC_PIN_Entry_CannotAccept", "DE22.2", 3),
//    RP_PINEntry_3("RP_PIN_Entry_CannotAccept", "DE22.2", 3),
//
//    VI_PINEntry_8("VISA_PIN_Entry_PINPadDown", "DE22.2", 8), MC_PINEntry_8("MC_PIN_Entry_PINPadDown", "DE22.2", 8),
//    RP_PINEntry_6("RP_PIN_Entry_PINPadDown", "DE22.2", 6), VI_PINEntry_9("VISA_PIN_Entry_FutureUse", "DE22.2", 9),
//    RP_PINEntry_8("RP_PIN_Entry_FutureUse", "DE22.2", 8),
//    RP_PINEntry_9("RP_PIN_Entry_PrivateUse_Biometric", "DE22.2", 9), EBT_PINEntry_0("EBT_Unspecified", "DE22.2", 0),
//    EBT_PINEntry_1("EBT_PIN_Entered", "DE22.2", 1), EBT_PINEntry_2("EBT_No_PIN_entry_capability", "DE22.2", 2),
//    EBT_PINEntry_3("EBT_Online_PIN", "DE22.2", 3), EBT_PINEntry_4("EBT_Offline_PIN_in_clear", "DE22.2", 4),
//    EBT_PINEntry_5("EBT_Offline_PIN_encrypted", "DE22.2", 5),
//    EBT_PINEntry_6("EBT_PIN_pad_inoperative", "DE22.2", 6), EBT_PINEntry_7("EBT_Offline_biometrics", "DE22.2", 7),
//    EBT_PINEntry_8("EBT_Other_offline_verifications_passport_DL", "DE22.2", 8),
//    EBT_PINEntry_9("EBT_Offline_biographics", "DE22.2", 9);
//
//    private String description;
//    private String associatedDE;
//    private Integer deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public Integer getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(int deValue) {
//        this.deValue = deValue;
//    }
//
//    private PINEntryCapability(String description, String associatedDE, int deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum POSConditionCode {
//    RP_POSCondCode_00("RP_POSCondCode_Normal", "DE25", "00"),
//    RP_POSCondCode_01("RP_POSCondCode_CardHolderNotPresent", "DE25", "01"),
//    RP_POSCondCode_02("RP_POSCondCode_UnattendedTerminal", "DE25", "02"),
//    RP_POSCondCode_03("RP_POSCondCode_MerchantSuspicious", "DE25", "03"),
//    RP_POSCondCode_05("RP_POSCondCode_CustomerPresent_CardNotPresent", "DE25", "05"),
//    RP_POSCondCode_07("RP_POSCondCode_IVR", "DE25", "07"), RP_POSCondCode_08("RP_POSCondCode_MOTO", "DE25", "08"),
//    RP_POSCondCode_51("RP_POSCondCode_AccountVerification_NoAuth", "DE25", "51"),
//    RP_POSCondCode_59("RP_POSCondCode_ECommerce", "DE25", "59"),
//    RP_POSCondCode_71("RP_POSCondCode_CardPresent_UnreadCard", "DE25", "71"),
//    VI_POSCondCode_00("VISA_POSCondCode_Normal", "DE25", "00"),
//    VI_POSCondCode_01("VISA_POSCondCode_CardHolderNotPresent", "DE25", "01"),
//    VIA_POSCondCode_02("VISA_POSCondCode_UnattendedTerminal_PINEntered", "DE25", "02"),
//    VI_POSCondCode_03("VISA_POSCondCode_MerchantSuspicious", "DE25", "03"),
//    VI_POSCondCode_05("VISA_POSCondCode_CustomerPresent_CardNotPresent", "DE25", "05"),
//    VI_POSCondCode_06("VISA_POSCondCode_PreAuthCompletion_Advice", "DE25", "06"),
//    VI_POSCondCode_08("VISA_POSCondCode_MOTO_Recurring", "DE25", "08"),
//    VI_POSCondCode_10("VISA_POSCondCode_CheckAcceptance_CHverified", "DE25", "10"),
//    VI_POSCondCode_11("VISA_POSCondCode_SuspectedFraud", "DE25", "11"),
//    VI_POSCondCode_12("VISA_POSCondCode_Security", "DE25", "12"),
//    VI_POSCondCode_51("VISA_POSCondCode_AccountVerificaiton_NoAuth", "DE25", "51"),
//    VI_POSCondCode_59("VISA_POSCondCode_ECommerce", "DE25", "59"),
//    VI_POSCondCode_71("VISA_POSCondCode_CardPresent_UnreadCard", "DE25", "71"),
//    VI_POSCondCode_73("VISA_POSCondCode_TokenBasedTxn_withCryptogram", "DE25", "73"),
//    MC_POSCondCode_0("	POS Terminal Attendance - Attended Terminal", "	DE61.01", "0"),
//    MC_POSCondCode_1("POS Terminal Attendance - Unattended terminal", "DE61.01", "1"),
//    MC_POSCondCode_2("POS Terminal Attendance -No terminal used", "DE61.01", "2"),
//    MC_POSCondCode_01("Mail Order - Internal", "DE61.4", "01"),
//    MC_POSCondCode_02("Telephone Order Attendance - Internal", "DE61.04", "02"),
//    MC_POSCondCode_03("COF File - Internal", "DE61.04", "03"),
//    EBT_POSCondCode_00("EBT_POSCondCode_Normal", "", "00"),
//    EBT_POSCondCode_01("EBT_POSCondCode_CustomerPresent_CardNotPresent", "", "01"),
//    EBT_POSCondCode_10("EBT_POSCondCode_CustomerNotPresent_CardPresent", "", "10"),
//    EBT_POSCondCode_11("EBT_POSCondCode_CustomerNotPresent_CardNotPresent", "", "11")
//
//    ;
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private POSConditionCode(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//}
//
//public enum CardDataInputCapability {
//    RP_CrdDtaInpCap_0("Unknown", "DE61.01", "0"),
//    RP_CrdDtaInpCap_1("Magnetic Stripe Read Capability", "DE61.01", "1"),
//    RP_CrdDtaInpCap_2("ICC Capability", "DE61.01", "2"),
//    RP_CrdDtaInpCap_3("Magnetic Stripe and Key Entry Capability", "DE61.01", "3"),
//    RP_CrdDtaInpCap_4("Magnetic stripe and ICC Capability", "DE61.01", "4"),
//    RP_CrdDtaInpCap_5("	Manual, no terminal", "DE61.01", "5"), RP_CrdDtaInpCap_6("Key entered", "DE61.01", "6"),
//    RP_CrdDtaInpCap_7("Contactless Only", "DE61.01", "7"),
//    RP_CrdDtaInpCap_8("Magnetic & Contact ICC & Contactless Capability", "DE61.01", "8"),
//    MC_CrdDtaInpCap_0("Unknown or unspecified", "DE61.11", "0"),
//    MC_CrdDtaInpCap_1("No terminal used (voice/ARU authorization); server", "DE61.11", "1"),
//    MC_CrdDtaInpCap_2("Magnetic stripe reader only", "DE61.11", "2"),
//    MC_CrdDtaInpCap_3("Contactless M/Chip (Proximity Chip)", "DE61.11", "3"),
//    MC_CrdDtaInpCap_4("Contactless Magnetic Stripe (Proximity Chip) only", "DE61.11", "4"),
//    MC_CrdDtaInpCap_5("	EMV specification (compatible chip reader) and magnetic stripe reader", "DE61.11", "5"),
//    MC_CrdDtaInpCap_6("Key entry only", "DE61.11", "6"),
//    MC_CrdDtaInpCap_7("Magnetic stripe reader and key entry", "DE61.11", "7"),
//    MC_CrdDtaInpCap_8("EMV specification (compatible chip reader), magnetic stripe reader and key entry", "DE61.11",
//            "8"),
//    VI_TermEntryCap_0("Unknown", "DE60.02", "0"), VI_TermEntryCap_1("Terminal not used", "DE60.02", "1"),
//    VI_TermEntryCap_2("Magnetic Stripe read capability", "DE60.02", "2"),
//    VI_TermEntryCap_3("Barcode read capability", "DE60.02", "3"),
//    VI_TermEntryCap_4("OCR read capability", "DE60.02", "4"),
//    VI_TermEntryCap_5("Chip capable terminal", "DE60.02", "5"),
//    VI_TermEntryCap_8("Proximity read capable terminal", "DE60.02", "8"),
//    VI_TermEntryCap_9("Terminal with no card reading capability", "DE60.02", "9"),;
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private CardDataInputCapability(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum CardholderAuthenticationCapability {
//    RP_CrdAuthCap_0("Unknown", "DE61.02", "0"), RP_CrdAuthCap_1("Non PIN or Biometric", "DE61.02", "1"),
//    RP_CrdAuthCap_2("PIN Entry", "DE61.02", "2"), RP_CrdAuthCap_3("Biometric", "DE61.02", "3");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private CardholderAuthenticationCapability(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
//
//public enum CardCaptureCapability {
//    RP_CrdCaptureCap_0("Unknown", "	DE61.03", "0"), RP_CrdCaptureCap_1("No capture capability", "DE61.03", "1"),
//    RP_CrdCaptureCap_2("Capture capability", "DE61.03", "2"),
//    MC_CrdCaptureCap_0("Terminal/operator has no card capture capability", "DE61.06", "0"),
//    MC_CrdCaptureCap_1("Terminal/operator has card capture capability", "DE61.06", "1");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private CardCaptureCapability(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
//
//public enum TerminalOperatingEnvironmentTerminalType {
//    RP_TermOperEnv_0("Unknown", "DE61.04", "0"),
//    RP_TermOperEnv_1("On premises of card acceptor, attended", "DE61.04", "1"),
//    RP_TermOperEnv_2("On premises of card acceptor, unattended", "DE61.04", "2"),
//    RP_TermOperEnv_3("Off premises of card acceptor, attended", "DE61.04", "3"),
//    RP_TermOperEnv_4("Off premises of card acceptor, unattended", "DE61.04", "4"),
//    RP_TermOperEnv_5("On premises of cardholder, unattended", "DE61.04", "5"),
//    RP_TermOperEnv_6("No terminal used", "DE61.04", "6"),
//    RP_TermOperEnv_7("On premises of card acceptor, attended M-POS", "DE61.04", "7"),
//    RP_TermOperEnv_8("On premises of card acceptor, unattended M-POS", "DE61.04", "8"),
//    RP_TermOperEnv_9("Off premises of card acceptor, attended M-POS", "DE61.04", "9"),
//    RP_TermOperEnv_A("Off premises of card acceptor, unattended M-POS", "DE61.04", "A"),
//    RP_TermOperEnv_B("On premises of cardholder, unattended M-POS, attended", "DE61.04", "B"),
//    RP_TermOperEnv_C("Dollar Terminal", "DE61.04", "C"), RP_TermOperEnv_D("Dollar mPoS Terminal", "DE61.04", "D"),
//    VI_TermOperEnv_0("Unspecified", "DE60.01", "0"),
//    VI_TermOperEnv_1(
//            "Unattended cardholder-activated, no authorization, below-floor-limit transaction (not valid in zero floor markets)",
//            "DE60.01", "1"),
//    VI_TermOperEnv_2("Automated Teller Machine", "DE60.01", "2"),
//    VI_TermOperEnv_3("Unattended cardholder-activated, authorized transaction", "DE60.01", "3"),
//    VI_TermOperEnv_4("Electronic cash register", "DE60.01", "4"),
//    VI_TermOperEnv_5("Home terminals owned by cardholder", "DE60.01", "5"),
//    VI_TermOperEnv_7("Attended Telephone device", "DE60.01", "7"), VI_TermOperEnv_8("Reserved", "DE60.01", "8"),
//    VI_TermOperEnv_9("Mobile Acceptance Solution (mPOS)", "DE60.01", "9"),
//    MC_TermOperEnv_0("POS Terminal Location On premises of card acceptor facility ", "DE61.03", "0"),
//    MC_TermOperEnv_1("POS Terminal Location Off premises of card acceptor facility - merchant terminal remote",
//            "DE61.03", "1"),
//    MC_TermOperEnv_2("POS Terminal Location Off premises of card acceptor facility - cardholder terminal ",
//            "DE61.03", "2"),
//    MC_TermOperEnv_3("POS Terminal Location - No Terminal used - IVR/ARU server", "DE61.03", "3"), MC_TermOperEnv_4(
//            "POS Terminal Location On premises of card acceptor facility -  Cardholder terminal", "DE61.03", "4");
//
//    private String description;
//    private String associatedValue;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedValue() {
//        return associatedValue;
//    }
//
//    public void setAssociatedValue(String associatedValue) {
//        this.associatedValue = associatedValue;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private TerminalOperatingEnvironmentTerminalType(String description, String associatedValue, String deValue) {
//        this.description = description;
//        this.associatedValue = associatedValue;
//        this.deValue = deValue;
//    }
//}
//
//public enum CardholderPresentData {
//    RP_CrdhldPresentDta_0("Unknown", "DE61.05", "0"), RP_CrdhldPresentDta_1("Cardholder Present", "DE61.05", "1"),
//    RP_CrdhldPresentDta_2("Cardholder not present, unspecified reason", "DE61.05", "2"),
//    RP_CrdhldPresentDta_3("Cardholder not present, Mail transaction", "DE61.05", "3"),
//    RP_CrdhldPresentDta_4("Cardholder not present, telephone transaction", "DE61.05", "4"),
//    RP_CrdhldPresentDta_5("Cardholder not present, standing instruction", "DE61.05", "5"),
//    RP_CrdhldPresentDta_6("E-commerce transaction", "DE61.05", "6"),
//    RP_CrdhldPresentDta_7("IVR transaction", "DE61.05", "7"),
//    RP_CrdhldPresentDta_8("Recurring Payment", "DE61.05", "8"),
//    MC_CrdhldPresentDta_0("Cardholder present", "DE61.04 ", "0"),
//    MC_CrdhldPresentDta_1("Cardholder not present, unspecified", "DE61.04", "1"),
//    MC_CrdhldPresentDta_2("Mail/facsimile order ", "DE61.04", "2"),
//    MC_CrdhldPresentDta_3("Phone/ARU order", "DE61.04", "3"),
//    MC_CrdhldPresentDta_4("Standing order/recurring transactions", "DE61.04", "4"),
//    MC_CrdhldPresentDta_5("Electronic order (home PC, Internet, mobile phone, PDA)", "DE61.04", "5");
//
//    private String description;
//    private String associatedValue;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedValue() {
//        return associatedValue;
//    }
//
//    public void setAssociatedValue(String associatedValue) {
//        this.associatedValue = associatedValue;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private CardholderPresentData(String description, String associatedValue, String deValue) {
//        this.description = description;
//        this.associatedValue = associatedValue;
//        this.deValue = deValue;
//    }
//}
//
//public enum CardPresentData {
//    RP_CrdPresentDta_0("Unknown", "DE61.06", "0"), RP_CrdPresentDta_1("Card not present", "DE61.06", "1"),
//    RP_CrdPresentDta_2("Card present", "DE61.06", "2"), MC_CrdPresentDta_0("Card Present", "DE61.05", "0"),
//    MC_CrdPresentDta_1("Card Not Present", "DE61.05", "1");
//
//    private String description;
//    private String associatedValue;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedValue() {
//        return associatedValue;
//    }
//
//    public void setAssociatedValue(String associatedValue) {
//        this.associatedValue = associatedValue;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private CardPresentData(String description, String associatedValue, String deValue) {
//        this.description = description;
//        this.associatedValue = associatedValue;
//        this.deValue = deValue;
//    }
//}
//
//public enum CardDataInputModeTerminalEntryCapability {
//    RP_CrdDtaInputMode_0("Unknown", "DE61.07", "0"),
//    RP_CrdDtaInputMode_1("Manual Input, no terminal", "DE61.07", "1"),
//    RP_CrdDtaInputMode_2("Magnetic Stripe read", "DE61.07", "2"),
//    RP_CrdDtaInputMode_3("Online Chip / Contact Chip", "DE61.07", "3"),
//    RP_CrdDtaInputMode_4("Offline chip / Contactless", "DE61.07", "4"),
//    RP_CrdDtaInputMode_5("Ecommerce", "DE61.07", "5"), RP_CrdDtaInputMode_6("IVR", "DE61.07", "6"),
//    RP_CrdDtaInputMode_7("Key entered", "DE61.07", "7");
//
//    private String description;
//    private String associatedValue;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedValue() {
//        return associatedValue;
//    }
//
//    public void setAssociatedValue(String associatedValue) {
//        this.associatedValue = associatedValue;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private CardDataInputModeTerminalEntryCapability(String description, String associatedValue, String deValue) {
//        this.description = description;
//        this.associatedValue = associatedValue;
//        this.deValue = deValue;
//    }
//}
//
//public enum CardholderAuthenticationmethod {
//    RP_CrdhldAuthenmethod_0("Unknown", "	DE61.08", "0"),
//    RP_CrdhldAuthenmethod_1("Not authenticated", "DE61.08", "1"), RP_CrdhldAuthenmethod_2("PIN", "DE61.08", "2"),
//    RP_CrdhldAuthenmethod_3("Signature", "DE61.08", "3"), RP_CrdhldAuthenmethod_4("Biometric_FMR", "DE61.08", "4"),
//    RP_CrdhldAuthenmethod_5("OTP", "DE61.08", "5"), RP_CrdhldAuthenmethod_6("ECommerce Type1 PIN", "DE61.08", "6"),
//    RP_CrdhldAuthenmethod_7("ECommerce Type1 OTP", "DE61.08", "7"),
//    RP_CrdhldAuthenmethod_8("ECommerce Type2", "DE61.08", "8"),
//    RP_CrdhldAuthenmethod_9("IVR Type1", "DE61.08", "9"), RP_CrdhldAuthenmethod_A("Biometric_FIR", "DE61.08", "A"),
//    RP_CrdhldAuthenmethod_B("Biometric_IIR", "DE61.08", "B"),
//    RP_CrdhldAuthenmethod_C("Biometric_PIN", "DE61.08", "C"),
//    RP_CrdhldAuthenmethod_D("Biometric_OTP", "DE61.08", "D"),
//    RP_CrdhldAuthenmethod_E("Biometric (FIT/FMR/IIR) with PIN", "DE61.08", "E"),
//    RP_CrdhldAuthenmethod_F("Biometric (FIT/FMR/IIR) with OTP", "DE61.08", "F"),
//    RP_CrdhldAuthenmethod_G("Authenticated using only OTP", "DE61.08", "G"),
//    VI_CrdhldAuthenmethod_0("Unspecified Cardholder ID method", "DE60.09", "0"),
//    VI_CrdhldAuthenmethod_1("Signature", "DE60.09", "1"), VI_CrdhldAuthenmethod_2("PIN", "DE60.09", "2"),
//    VI_CrdhldAuthenmethod_3("Unattended terminal, no PIN pad", "DE60.09", "3"),
//    VI_CrdhldAuthenmethod_4("Mail/Telephone/Electronic Commerce", "DE60.09", "4");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private CardholderAuthenticationmethod(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
//
//public enum CardholderAuthenticationEntity {
//    RP_CrdhldAuthenEntity_0("Unknown", "	DE61.09", "0"), RP_CrdhldAuthenEntity_1("ICC", "DE61.09", "1"),
//    RP_CrdhldAuthenEntity_2("CAD", "DE61.09", "2"),
//    RP_CrdhldAuthenEntity_C("Type 3 (3D if issuer opted for ICS 1 services)", "DE61.09", "C"),
//    RP_CrdhldAuthenEntity_D("Type 4 (3D if issuer opted for ICS 2 services)", "DE61.09", "D"),
//    RP_CrdhldAuthenEntity_A("Type 1 (RuPay E-Commerce Implementation)", "DE61.09", "A"),
//    RP_CrdhldAuthenEntity_I("Type 2 (3D if issuer opted for RuPay services)", "DE61.09", "I");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private CardholderAuthenticationEntity(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
//
//public enum CardDataOutputCapability {
//    RP_CrdDtaOutputCap_0("Unknown", "DE61.10", "0"), RP_CrdDtaOutputCap_1("Magnetic Stripe write", "DE61.10", "1"),
//    RP_CrdDtaOutputCap_2("ICC Write", "DE61.10", "2");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private CardDataOutputCapability(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum TerminalDataOutputCapability {
//    RP_TermDtaOutputCap_0("Unknown", "DE61.11", "	0"), RP_TermDtaOutputCap_1("Print Capability", "DE61.11", "1"),
//    RP_TermDtaOutputCap_2("Display Capability", "DE61.11", "2"),
//    RP_TermDtaOutputCap_3("Print and Display Capability", "DE61.11", "3");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private TerminalDataOutputCapability(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
////
////	public enum PINCaptureCapability {
////		RP_PINCaptureCap_0("No PIN capture capability / Unknown", "	DE61.12", "0"),
////		RP_PINCaptureCap_1("4 chars maximum", "DE61.12", "1"), RP_PINCaptureCap_2("5 chars maximum", "DE61.12", "2"),
////		RP_PINCaptureCap_3("6 chars maximum", "DE61.12", "3"), RP_PINCaptureCap_4("7 chars maximum", "DE61.12", "4"),
////		RP_PINCaptureCap_5("8 chars maximum", "DE61.12", "5"), RP_PINCaptureCap_6("9 chars maximum", "DE61.12", "6"),
////		RP_PINCaptureCap_7("10 chars maximum", "DE61.12", "7"), RP_PINCaptureCap_8("11 chars maximum", "DE61.12", "8"),
////		RP_PINCaptureCap_9("12 chars maximum", "DE61.12", "9"),
////		VI_PINCaptureCap_00("Unknown /Unspecified", "DE26", "00"), VI_PINCaptureCap_04("4 chars maximum", "DE26", "04"),
////		VI_PINCaptureCap_05("5 chars maximum", "DE26", "05"), VI_PINCaptureCap_06("6 chars maximum", "DE26", "06"),
////		VI_PINCaptureCap_07("7 chars maximum", "DE26", "07"), VI_PINCaptureCap_08("8 chars maximum", "DE26", "08"),
////		VI_PINCaptureCap_09("9 chars maximum", "DE26", "09"), VI_PINCaptureCap_10("10 chars maximum", "DE26", "10"),
////		VI_PINCaptureCap_11("11 chars maximum", "DE26", "11"), VI_PINCaptureCap_12("12 chars maximum", " DE26", "12");
////
////		private String description;
////		private String associatedDE;
////		private String deValue;
////
////		private PINCaptureCapability(String description, String associatedDE, String deValue) {
////			this.description = description;
////			this.associatedDE = associatedDE;
////			this.deValue = deValue;
////		}
////
////		public String getDescription() {
////			return description;
////		}
////
////		public void setDescription(String description) {
////			this.description = description;
////		}
////
////		public String getAssociatedDE() {
////			return associatedDE;
////		}
////
////		public void setAssociatedDE(String associatedDE) {
////			this.associatedDE = associatedDE;
////		}
////
////		public String getDeValue() {
////			return deValue;
////		}
////
////		public void setDeValue(String deValue) {
////			this.deValue = deValue;
////		}
////	}
//
//public enum ChipConditionCode {
//    VI_ChipCondCode_0("	Not Applicable", "DE60.03", "0"),
//    VI_ChipCondCode_1("Fallback to Magnetic Stripe, prior chip read successful or not a chip transaction",
//            "DE60.03", "1"),
//    VI_ChipCondCode_2("Fallback to Magnetic Stripe, prior chip read unsuccessful", "DE60.03", "2");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private ChipConditionCode(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
//
//public enum SpecialConditionIndicator {
//    VI_SpecialCondInd_0("Default Value", "DE60.04", "0"),
//    VI_SpecialCondInd_9("Existing debt indicator", "DE60.04", "9");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private SpecialConditionIndicator(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum ChipTransactionIndicator {
//    VI_ChipTransactionInd_0("Not Applicable as Early Data option used by Acquirer", "DE60.06", "0"),
//    VI_ChipTransactionInd_1("Standard third bitmap or DE55 is used", "DE60.06", "1"),
//    VI_ChipTransactionInd_2("Expanded third bitmap used", "DE60.06", "2"),
//    VI_ChipTransactionInd_3("V.I.P dropped chip data due to invalid format", "DE60.06", "3"),
//    VI_ChipTransactionInd_4("VISA generated token data", "DE60.06", "4");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private ChipTransactionIndicator(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum ChipCardAuthenticationReliabilityIndicator {
//    VI_ChipAuthenReliable_0("Fill for Field 60.07. Subsequent DE60 fields present", "DE60.07", "0"),
//    VI_ChipAuthenReliable_1("Acquirer indicates that Card Authentication may not be reliable", "DE60.07", "1"),
//    VI_ChipAuthenReliable_2("V.I.P. indicates acquirer inactive for Card Authentication", "DE60.07", "2"),
//    VI_ChipAuthenReliable_3("V.I.P. indicates issuer inactive for Card Authentication", "DE60.07", "3");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private ChipCardAuthenticationReliabilityIndicator(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum MOTOECommerceandPaymentIndicator {
//    VI_MOTOEcomPaymnt_00("Not Applicable", "	DE60.08", "00"),
//    VI_MOTOEcomPaymnt_01("Mail Order /Telephone Order", "	DE60.08", "01"),
//    VI_MOTOEcomPaymnt_02("Recurring Transaction", "	DE60.08", "02"),
//    VI_MOTOEcomPaymnt_03("Installment Payment	", "	DE60.08", "03"),
//    VI_MOTOEcomPaymnt_04("Unknown classification", "	DE60.08", "04"),
//    VI_MOTOEcomPaymnt_05("Secure Electronic Commerce transaction", "	DE60.08", "05"),
//    VI_MOTOEcomPaymnt_06(
//            "Non-authenticated security transaction at a 3-D Secure-capable merchant, and merchant attempted to authenticate the cardholder using 3-D Secure",
//            "	DE60.08", "06"),
//    VI_MOTOEcomPaymnt_07("Non-authenticated Security transaction", "	DE60.08", "07"),
//    VI_MOTOEcomPaymnt_08("Non-secure transaction", "	DE60.08", "08"),
//    VI_MOTOEcomPaymnt_09("Reserved", "	DE60.08", "09"),;
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private MOTOECommerceandPaymentIndicator(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum PartialAuthorizationIndicator {
//    VI_PartialAuth_0("Terminal does not process partial authorization responses", "DE60.10", "0"),
//    VI_PartialAuth_1("Terminal accepts partial authorization responses", "DE60.10", "1");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private PartialAuthorizationIndicator(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum POSTransactionStatus {
//    MC_POSTranStatus_0("Normal request (original presentment)", "DE61.07", "0"),
//    MC_POSTranStatus_2("SecureCode Phone Order", "DE61.07", "2"),
//    MC_POSTranStatus_3("ATM Installment Inquiry", "DE61.07", "3"),
//    MC_POSTranStatus_4("Preauthorized request", "DE61.07", "4"),
//    MC_POSTranStatus_5("Time Based Payment Authorization Request—Brazil domestic", "DE61.07", "5"),
//    MC_POSTranStatus_6("ATC Update", "DE61.07", "6"),
//    MC_POSTranStatus_8("Account Status Inquiry Service (ASI)", "DE61.07", "8"),
//    MC_POSTranStatus_9("Tokenization Request/Notification", "DE61.07", "9");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    private POSTransactionStatus(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//}
//
//public enum POSTransactionSecurity {
//    MC_POSTranSecurity_0("No Security concern", "DE61.08", "0"),
//    MC_POSTranSecurity_1("Suspected fraud (merchant suspicious—code 10)", "DE61.08", "1"),
//    MC_POSTranSecurity_2("ID verified", "DE61.08", "2");
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private POSTransactionSecurity(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum CardholderActivatedTerminalLevel {
//    MC_CrdhldActTermLvl_0("Not a CAT transaction", "	DE61.10", "0"),
//    MC_CrdhldActTermLvl_1("CAT 1- Automated dispensing machine with PIN", "DE61.10", "1"),
//    MC_CrdhldActTermLvl_2("CAT 2 - Self-service terminal", "	DE61.10", "2"),
//    MC_CrdhldActTermLvl_3("CAT 3 - Limited-amount terminal", "	DE61.10", "3"),
//    MC_CrdhldActTermLvl_4("CAT 4 - In-flight commerce", "	DE61.10", "4"),
//    MC_CrdhldActTermLvl_5("CAT 5 - Reserved", "	DE61.10", "5"),
//    MC_CrdhldActTermLvl_6("CAT 6 - Electronic commerce", "	DE61.10", "6"),
//    MC_CrdhldActTermLvl_7("CAT 7 - Transponder transaction", "	DE61.10", "7"),
//    MC_CrdhldActTermLvl_8("CAT 8 - Reserved for future use", "	DE61.10", "8"),
//    MC_CrdhldActTermLvl_9("CAT 9 - MPOS Acceptance Device", "	DE61.10", "9"),;
//
//    private String description;
//    private String associatedDE;
//    private String deValue;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssociatedDE() {
//        return associatedDE;
//    }
//
//    public void setAssociatedDE(String associatedDE) {
//        this.associatedDE = associatedDE;
//    }
//
//    public String getDeValue() {
//        return deValue;
//    }
//
//    public void setDeValue(String deValue) {
//        this.deValue = deValue;
//    }
//
//    private CardholderActivatedTerminalLevel(String description, String associatedDE, String deValue) {
//        this.description = description;
//        this.associatedDE = associatedDE;
//        this.deValue = deValue;
//    }
//}
//
//public enum BlacklistSourceEnum {
//    MC, VISA, RUPAY, ACQUIRER, THIRDPARTY, AMEX
//}
//
////	public enum BlacklistedPincodeRegionEnum {
////		EST_ADD, EST_REG, FW_CURR, FW_PREV, Establishment, Registered,  FirstOwner_Current, FirstOwner_Previous, SecondOwner_Current, SecondOwner_Previous
////	}
//
//public enum NormalAuthorizationModeEnum {
//    FEES, DCC, EMI, CASH_BACK
//}
//
//public enum HelpCategory {
//    USERSCREEN, REPORTS, FUNCTIONAL, TECHNICAL, SCREENS, LAYOUTS, PROGRAMS, MANUALS
//}
//
//public enum HelpSubCategory {
//    DEFAULT, BUSOPS, MERCSS, ALLPART, DASHBOARDS, DOWNLOADS, SETTINGS, UTILITY, SEARCH, HELP, QUEUE, NOTIFICATIONS,
//    APIS, INCOMING, OUTGOING, PROCESSING, REPORTING, CONVERSION, APPLICATION_CREATION, SERVICE_REQUEST,
//    INSTALLATION_GUIDE, LOAD_PERFORMANCE, MERCHANR_SELF_SERVICE, SOPs, SPLIT_PAYMENTS, DISPUTES
//}
//
//public enum PostingIndentifierEnum {
//    AUTHORIZATION, MERCHANT_SETTLEMENT, BATCH, ONLINE
//}
//
//public enum HelpDocumentStatus {
//    DRAFT, PUBLISH
//}
//
//public enum TerminalSettlementEnum {
//    AUTO, MANUAL
//}
//
//public enum SettlementTypeEnum {
//    SETTLE, SETTLE_WITH_TRAN
//}
//
//public enum CardExpiryFormatEnum {
//    yymm, mmyy
//}
//
//public enum EncryptionTypeEnum {
//    CN, ED
//}
//
//public enum EncryptionAlgoEnum {
//    AES, RSA, SHA512, SHA256
//}
//
//public enum YesNoNaEnum {
//    YES, NO, NA
//}
//
//public enum ReportFileTypeEnum {
//    csv, txt, pdf, json, xml, dat
//}
//
//public enum ReportLocationTypeEnum {
//    FILESYSTEM, GOOGLECLOUDSTORAGE, AMAZONS3
//}
//
//public enum ReportFileEnum {
//    R001("R001", "New Merchants", "tbr001", ReportFileTypeEnum.csv),
//    R002("R002", "New Terminals", "tbr002", ReportFileTypeEnum.csv),
//    R003("R003", "Additional Terminal", "tbr003", ReportFileTypeEnum.csv),
//    R004("R004", "Rejected Application", "tbr004", ReportFileTypeEnum.csv),
//    R005("R005", "Aggregator Share Report", "tbr005", ReportFileTypeEnum.csv),
//    R006("R006", "Reject Report Report", "trp006", ReportFileTypeEnum.csv),
//    R005_1("R005_1", "Other Commision Share Report", "tbr005", ReportFileTypeEnum.csv),
//    R005_2("R005_2", "Maximum Aggregator Share Report", "tbr005", ReportFileTypeEnum.csv),
//    R007("R007", "New Chain Merchants", "tbr007", ReportFileTypeEnum.csv),
//    R008("R008", "Dropped Chain Merchant", "tbr008", ReportFileTypeEnum.csv),
//    R009("R009", "New Merchant in Chain", "tbr009", ReportFileTypeEnum.csv),
//    R010("R010", "Dropped Merchant From Chain", "tbr010", ReportFileTypeEnum.csv),
//    R013("R013", "Terminal Installation", "tbr013", ReportFileTypeEnum.csv),
//    RO14("R014", "Statement Report", "trp014", ReportFileTypeEnum.csv),
//    R015("R015", "Daily auth transactions", "tbr015", ReportFileTypeEnum.csv),
//    R015_1("R015_1", "MIS Report", "tbr015", ReportFileTypeEnum.csv),
//    R016("R016", "Daily push transactions", "tbr016", ReportFileTypeEnum.csv),
//    R018("R018", "Terminal Installation Report", "trp018", ReportFileTypeEnum.csv),
//    R020("R020", "Clearing transaction Report", "trp003", ReportFileTypeEnum.csv),
//    R020_ERR("R020_ERR", "Clearing Transaction Error Report", "trp003", ReportFileTypeEnum.csv),
//    R021("R021", "Outstanding Clearing Settlement", "tbr021", ReportFileTypeEnum.csv),
//    R021_1("R021_1", "Outstanding Clearing Settlement", "tbr055", ReportFileTypeEnum.csv),
//    R027("R027", "Posting Successful", "tbr027", ReportFileTypeEnum.csv),
//    R027_1("R027_1", "Posting Successful", "tbr055", ReportFileTypeEnum.csv),
//    R028("R028", "Posting Unsuccessful", "tbr028", ReportFileTypeEnum.csv),
//    R029("R029", "Unsuccessful Merchant Payment Generation", "tbr029", ReportFileTypeEnum.csv),
//    R030("R030", "tax1  Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_1("R030_1", "tax2  Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_2("R030_2", "tax3  Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_3("R030_3", "tax1 Summary Tax Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_4("R030_4", "tax2 Summary Tax Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_5("R030_5", "tax3 Summary Tax Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_6("R030_6", "tax4   Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_7("R030_7", "tax4 Summary Tax Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_8("R030_8", "tax5  Report", "tbr030", ReportFileTypeEnum.csv),
//    R030_9("R030_9", "tax5 Summary Tax Report", "tbr030", ReportFileTypeEnum.csv),
//    R031("R031", "Reject Repost", "tbr031", ReportFileTypeEnum.csv),
//    R032("R032", "Report For Switch Transaction", "tbr032", ReportFileTypeEnum.csv),
//    R032_1("R032_1", "Switch Summary Report", "tbr032", ReportFileTypeEnum.csv),
//    R032_2("R032_2", "Switch PreAuth Summary Report", "tbr032", ReportFileTypeEnum.csv),
//    R032_3("R032_3", "Switch PreAuth Log Total Summary Report", "tbr032", ReportFileTypeEnum.csv),
//    R032_4("R032_4", "Switch PreAuth Complete Summary Report", "tbr032", ReportFileTypeEnum.csv),
//    R033("R033", "Outstanding for retrival request", "tbr033", ReportFileTypeEnum.csv),
//    R034("R034", "Hold Released", "tbr034", ReportFileTypeEnum.csv),
//    R035("R035", "Outgoing Summary Report", "tbr035", ReportFileTypeEnum.csv),
//    R036("R036", "Outstanding for ChargeBack", "tbr036d", ReportFileTypeEnum.csv),
//    R037("R037", "Outstanding for pre-arbitration", "tbr037", ReportFileTypeEnum.csv),
//    R038("R038", "Merchant Hold Transacion", "tbr038", ReportFileTypeEnum.csv),
//    R039("R039", "Incomming Settlement Summary", "tbr039", ReportFileTypeEnum.csv),
//    R041("R041", "General Ledger", "tbr041", ReportFileTypeEnum.csv),
//    R042("R042", "Channel Wise", "tbr042", ReportFileTypeEnum.csv),
//    R043("R043", "Merchant HOld Transaction", "tbr043", ReportFileTypeEnum.csv),
//    R044("R044", "Default Interchange For VISA", "tbr044", ReportFileTypeEnum.csv),
//    R046("R046", "Default Interchange For MasterCard", "tbr046", ReportFileTypeEnum.csv),
//    R047("R047", "Split Transaction Report", "tbr047", ReportFileTypeEnum.csv),
//    R048("R048", "DCC Daily Report", "tbr048", ReportFileTypeEnum.csv),
//    R049("R049", "Settlement Due Report", "tbr049", ReportFileTypeEnum.csv),
//    R050("R050", "Merchant Payment Successful Report", "tbr050", ReportFileTypeEnum.csv),
//    R051("R051", "UnSuccessful Payment Report", "tbr051", ReportFileTypeEnum.csv),
//    R052("R052", "Daily SR Report", "tbr052", ReportFileTypeEnum.csv),
//    R053("R053", "Reversal Transaction Report", "tbr053", ReportFileTypeEnum.csv),
//    R054("R054", "Rupay Incoming Error Report", "trp008", ReportFileTypeEnum.csv),
//    R057("R057", "Dispute Report", "tbr055", ReportFileTypeEnum.csv),
//    R058("R058", "Refund Report", "tbr055", ReportFileTypeEnum.csv),
//    R059("R059", "Representment Report", "tbr055", ReportFileTypeEnum.csv),
//    R060("R060", "Outgoing Claim Summary Report", "tbr055", ReportFileTypeEnum.csv),
//    R061("R061", "Incomming Settlement Report", "tbr055", ReportFileTypeEnum.csv),
//    R145("R145", "New Applications", "tbr145", ReportFileTypeEnum.csv),
//    R200("R200", "Maintainace Report", "tbr200", ReportFileTypeEnum.csv),
//    R201("R201", "Duplicate Application Approved", "tbr201", ReportFileTypeEnum.csv),
//    R202("R202", "SLA Crossed Application", "tbr202", ReportFileTypeEnum.csv),
//    RAcq("RAcq", "Acquirer Statistics Report", "tbr146", ReportFileTypeEnum.csv),
//    RMer("RMer", "Profitability", "tbr146", ReportFileTypeEnum.csv),
//    R094("R094", "Sales Leads Report", "tbr094", ReportFileTypeEnum.csv),
//
//    T001C("T001C", "Credit and Debit payment File", "trp001CreditFile", ReportFileTypeEnum.csv),
//    T001D("T001C", "Credit and Debit payment File", "trp001DebitFile", ReportFileTypeEnum.csv),
//    T001("T001", "Single Credit File", "trp001", ReportFileTypeEnum.csv),
//    T002("T002", "Merchnat Profile Statistics", "trp002", ReportFileTypeEnum.csv),
//    T003ER("T003ER", "Transaction Error File", "trp003ClearingErrorFile", ReportFileTypeEnum.csv),
//    T003P("T003P", "PTLF file", "trp003_PTLF", ReportFileTypeEnum.dat),
//    T004_R_OFF("T004", "Rupay Offus", "trp004", ReportFileTypeEnum.csv),
//    T004_R_ON("T004", "Rupay Onus", "trp004", ReportFileTypeEnum.csv),
//    T004_V("T004", "Visa Report", "trp004", ReportFileTypeEnum.csv),
//    T004_R("T004", "Rupay Report", "trp004", ReportFileTypeEnum.csv),
//    T004_V_OUT("T004", "Visa Outgoing", "trp004", ReportFileTypeEnum.csv),
//    T004_ONUS_OUT("T004", "Onus Outgoing report", "trp004", ReportFileTypeEnum.csv),
//    T004_ONUS("T004", "Onus Report", "trp004", ReportFileTypeEnum.csv),
//    T004_MC("T004", "Master Card Outgoing", "trp004", ReportFileTypeEnum.csv),
//    T004_MC_R("T004", "Master Card Report", "trp004", ReportFileTypeEnum.csv),
//    T004_EBT("T004", "EBT Outgoing", "trp004", ReportFileTypeEnum.csv),
//    T004_EBT_R("T004", "EBT Report", "trp004", ReportFileTypeEnum.csv),
//    T005_ERR("T005_ERR", "Clearing Error File", "trp005", ReportFileTypeEnum.csv),
//    T005_S("T005_S", "Summary Clearing Report", "trp005", ReportFileTypeEnum.csv),
//    T007("T007", "PTLF Successfull Report", "trp007", ReportFileTypeEnum.csv),
//    T008("T008", "Rupay Incoming Summary report", "trp008", ReportFileTypeEnum.csv),
//    T009("T009", "Visa Incoming report", "trp009", ReportFileTypeEnum.csv),
//    T013("T013", "Rebate transaction posting", "trp013", ReportFileTypeEnum.csv),
//    T020("T020", "Credit Debit Output", "trp020", ReportFileTypeEnum.csv),
//    T022("T022", "T022Xml", "trp022", ReportFileTypeEnum.csv),
//    T022_Err("T022", "T022MerchantError", "trp022", ReportFileTypeEnum.csv),
//    T032("T032", "trp032ReportFile", "trp032", ReportFileTypeEnum.csv),
//    T033("T033", "trp033ReportFile", "trp033", ReportFileTypeEnum.csv),
//    T034("T034", "trp034ReportFile", "trp034", ReportFileTypeEnum.csv),
//    T040("T040", "trp040ReportFile", "trp040", ReportFileTypeEnum.csv),
//    T041("T041", "trp041Errfile", "trp041", ReportFileTypeEnum.csv),
//    T046("T046", "trp046", "trp046", ReportFileTypeEnum.csv),
//    T051("T051", "Merchant Application KYC report ", "trp051", ReportFileTypeEnum.csv),
//    T066("T066", "Posting Successfull Report", "trp066", ReportFileTypeEnum.csv),
//    T072("T072", "Offers Eligible report", "trp072", ReportFileTypeEnum.csv),
//    T073_1("T073_1", "Offer Ptlf Report", "trp073", ReportFileTypeEnum.csv),
//    T073_2("T073_2", "Consumer Offer Ptlf Report", "trp073", ReportFileTypeEnum.csv),
//    T075("T075", "SingleCreditDebit File Report", "trp075", ReportFileTypeEnum.csv),
//
//    R014("R014", "Merchant BulkUpload", "tup009", ReportFileTypeEnum.csv),
//    R055("R055", "MerchantHeadTrailUpload", "tup010", ReportFileTypeEnum.csv),
//    R056("R056", "OnboardingExcelHelper", "tup025", ReportFileTypeEnum.csv),
//    R055_AuditReport("R055_AuditReport", "MerchantHeadTrailUpload", "tup010_AuditReport", ReportFileTypeEnum.csv),
//
//    // Need to remove AfterWards
//    TUP009("", "", "", ReportFileTypeEnum.csv),
//    T005_P("T005", "Posting Record Writer", "trp005", ReportFileTypeEnum.csv),
//
//    MIS("MIS", "MIS Report", "tbr015", ReportFileTypeEnum.csv),
//
//    // EBT Reports
//    ER21("ER21", "Txn Settled by FIS for EBT", "tebt21", ReportFileTypeEnum.csv),
//    ER22("ER22", "EBT txn acqReports", "tebt22", ReportFileTypeEnum.csv),
//    ER22_1("ER22_1", "EBT Refund txn Reports", "tebt22", ReportFileTypeEnum.csv),
//    ER22_2("ER22_2", "EBT txns using Key_Entry", "tebt22", ReportFileTypeEnum.csv),
//    ER22_3("ER22_3", "EBT cash Txns", "tebt22", ReportFileTypeEnum.csv);
//
//    private String reportId;
//    private String reportDesc;
//    private String reportFileId;
//    private ReportFileTypeEnum reportFileType;
//
//    public String getReportId() {
//        return reportId;
//    }
//
//    public String getReportDesc() {
//        return reportDesc;
//    }
//
//    public String getReportFileId() {
//        return reportFileId;
//    }
//
//    public ReportFileTypeEnum getReportFileType() {
//        return reportFileType;
//    }
//
//    private ReportFileEnum(String reportId, String reportDesc, String reportFileId,
//                           ReportFileTypeEnum reportFileType) {
//        this.reportId = reportId;
//        this.reportDesc = reportDesc;
//        this.reportFileId = reportFileId;
//        this.reportFileType = reportFileType;
//    }
//
//}
//
//public enum ProcessStatusEnum {
//    INPROGRESS, FILEERRORABORTED, COMPLETED
//}
//
//public enum ProcessCategoryEnum {
//    SCHEME_SETTLE_INCOMING, SCHEME_SETTLE_OUTGOING, BILL_PAY_INPUT, CLEARING, POSTING_INPUT, REPORTING,
//    PARAMETER_UPD
//}
//
//public enum EntitiyTypeEnum {
//    INTERFACE, DEVICE
//}
//
//public enum MessagingQueueEnum {
//    INTERNAL, REDIS
//}
//
//public enum RecordStatusEnum {
//    PENDING_SETUP, ACTIVE, DE_ACTIVATED
//}
//
//public enum ChannelReportTLEnum {
//    TRANS, MDR, TDS, GST, REFUND, MDR_REV, TDS_REV, GST_REV
//}
//
//public enum SwitchTxnTypeEnum {
//    ECOMM, POS, MATM, QRCODE, BIOMETRIC, IBANK, WALLET, FACEID
//}
//
//public enum MDSVerifyMethodEnum {
//    API_PAYNEXT
//}
//
//public enum MccStatusFlag {
//    NORMAL, PROHIBITED, RESTRICTED
//}
//
//public enum InOutFlag {
//    IN, OUT
//}
//
//public enum FinancialYearStartEnum {
//    JANUARY, APRIL
//}
//
//public enum TiredVolFrequencyEnum {
//    DAILY, MONTHLY, QUARTERLY, ANNUALLY
//}
//
//public enum AllianceOrgAggregatorEnum {
//    AGGREGATOR, AGENT, OFFERSPONSOR
//}
//
//public enum TransitCardStatusEnum {
//    NEW, ACTIVE, INACTIVE, BLOCK, LOST, STOLEN
//}
//
//public enum TripStatusEnum {
//    INITATED, COMPLETED, CANCELLED
//}
//
//public enum MerchantReimbursementEnum {
//    TRANSACTION, OFFEREND, TXN_nDAYS
//}
//
//public enum StackHolder {
//    MANUFACTURER, ISSUER, ACQUIRER, MERCHANT, NON_MERCHANT
//}
//
//public enum ConsumerOfferType {
//    EMI, DISCOUNT, CASHBACK
//}
//
//public enum ManufacturerReimbursement {
//    ACQUIRER, MERCHANT
//}
//
//public enum ClearingReportTxnEnum {
//    APPROVED, REJECTED, REVERSAL, VOID, REFUND, PREAUTH
//}
//
//public enum AverageAuthFrequencyEnum {
//    DAILY, LAST_SEVEN_DAYS, LAST_FIFTEEN_DAYS, LAST_MONTH
//}
//
//public enum ProductionRegionEnum {
//    QFIX_PROD, RBL_PROD
//}
//
//public enum TerminalLineEncryptionEnum {
//    CERTIFIED, NON_CERTIFIED
//}
//
//public enum TerminalEncryptionTypeEnum {
//    UKPT_ENCRYPTION, DUKPT_ENCRYPTION, NON_ENCRYPTION, THREE_DS_ENCRYPTION, TLE_COMPLIANT // need to removed
//}
//
//public enum TLEComplaintEnum {
//    TLE_CERTIFIED, TLE_NON_CERTIFIED
//}
//
//public enum ServiceFunctionEnum {
//
//    ALLIANCE_USER_AUTH_SERVICE(false, false), BUREAU_SERVICE(false, false), CARD_AUTH_SERVICE(true, false),
//    EMAIL_RECEIVE_SERVICE(false, true), EMAIL_SERVICE(false, false), EXTERNAL_USER_AUTH_SERVICE(false, false),
//    FUND_TRANSFER_REGISTRATION_SERVICE(false, false), FUND_TRANSFER_SERVICE(false, false),
//    HSM_SERVICE(false, false), IBANKING_SERVICE(true, false), IN_CORPORATE_GST_SERVICE(false, false),
//    IN_CORPORATE_PAN_SERVICE(false, false), IN_INDIVIDUAL_OCR_SERVICE(false, false),
//    IN_CORPORATE_ROC_SERVICE(false, false), IN_INDIVIDUAL_ADHAAR_SERVICE(false, false),
//    IN_INDIVIDUAL_DL_SERVICE(false, false), IN_INDIVIDUAL_GST_SERVICE(false, false),
//    IN_INDIVIDUAL_PAN_SERVICE(false, false), IN_INDIVIDUAL_BANK_SERVICE(false, false),
//    IN_INDIVIDUAL_PASSPORT_SERVICE(false, false), IN_INDIVIDUAL_TAN_SERVICE(false, false),
//    IN_INDIVIDUAL_VOTER_SERVICE(false, false), INTERNAL(false, false), KYC_SERVICE(false, false),
//    MERCHANT_CREATION_SERVICE(false, false), MERCHANT_NUMBER_GEN_SERVICE(true, false),
//    MESSAGING_SERVICE(false, false), OAUTH2_SERVICE(true, false), OPS_INAPP_NOTIFICATION(false, false),
//    P2P_AUTH_SERVICE(false, false), P2P_REGISTRATION_SERVICE(false, false), PAY_OUT_SERVICE(false, false),
//    SMS_SERVICE(false, false), SS_INAPP_NOTIFICATION(false, false), SYSUSER_AUTH_SERVICE(false, false),
//    TERMINAL_NUMBER_GEN_SERVICE(true, false), TRAN_QR_GEN_SERVICE(false, false), WALLET_AUTH_SERVICE(false, false),
//    WALLET_REGISTRATION_SERVICE(false, false), WHATSAPP_SERVICE(false, false),
//    IN_INDIVIDUAL_IFSC_SERVICE(false, false), FILE_FORMAT_CONVERSION(false, false),
//    SCAN_UPLOADED_FILE(false, false), UPI_SERVICE(true, false), CALLBACK_SERVICE(false, false),
//
//    // need to remove
//    GEN_ASYM_PAIR_4_AUTH(false, false), GEN_SYM_4_AUTH(false, false), GEN_DERIVED_INITIAL_4_AUTH(false, false),
//    GEN_PEK_DUKPT_4_AUTH(false, false), LOD_KEY_4_AUTH(false, false), TSL_PIN_4_AUTH(false, false),
//    LST_KEY_4_AUTH(false, false), WRP_UNDER_PUBLIC_4_AUTH(false, false), WRP_UNDER_KEK_4_AUTH(false, false),
//    MATCH_VERIFICATION(false, false), RAMP_VERIFICATION(false, false);
//
//    private boolean multProvider;
//    // Only true for service where toucan need to call external service in a
//    // continious loop
//    private boolean autoExecutionLoop;
//
//    public boolean canHaveMutipleProvider() {
//        return multProvider;
//    }
//
//    public boolean shouldBeAutoExecutionLoop() {
//        return autoExecutionLoop;
//    }
//
//    private ServiceFunctionEnum(boolean multProvider, boolean autoExecutionLoop) {
//        this.multProvider = multProvider;
//        this.autoExecutionLoop = autoExecutionLoop;
//    }
//
//}
//
//public enum NatureOfBusinessEnumVsBusinessTypeEnum {
//    AD("Drug and/or Alcohol Treatment Program", false), BB("Bakery Specialty", true),
//    BC("Non-profit Food Buying Co-op", true), BW("Shelter for Battered Women and Children", false),
//    CA("Community Supported Agriculture Organization", true), CD("Communal Dining Facility", false),
//    CO("Combination Grocery/Other", true), CS("Convenience Store", true), DR("Delivery Route", true),
//    DF("Direct Marketing Farmer", true), FM("Farmers’ Market", true), FV("Fruits/Vegetable Specialty", true),
//    GL("Group Living Arrangement", false), HP("Homeless Meal Provider", false), IR("Internet Retailer", true),
//    LG("Large Grocery Store", true), MC("Military Commissary", true), MD("Meal Delivery Service", false),
//    ME("Meat/Poultry Specialty", true), MG("Medium Grocery Store", true),
//    RE("Private Restaurant/Meal Delivery", false), SC("Senior Citizens’ Center/Residential Building", false),
//    SE("Seafood Specialty", true), SG("Small Grocery Store", true), SM("Supermarket", true),
//    SS("Super Store", true), WH("Wholesaler", true);
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public boolean isStore() {
//        return isStore;
//    }
//
//    public void setStore(boolean isStore) {
//        this.isStore = isStore;
//    }
//
//    String description;
//    boolean isStore;
//
//    private NatureOfBusinessEnumVsBusinessTypeEnum(String desc, boolean isStore) {
//        this.description = desc;
//        this.isStore = isStore;
//    }
//}
//
//public enum ProviderEnum {
//
//    MERCHANT_CREATION_TOUCAN, MERCHANT_CREATION_NO_CREATE, FUND_TRANSFER_RBL, FUND_TRANSFER_REGISTRATION_RBL,
//    MERCHANT_NUMBER_GEN_PAYNEXT, CARD_AUTH_PAYNEXT, CARD_AUTH_HDFC, IBANKING_CCAVENUE_IN,
//    TERMINAL_NUMBER_GEN_PAYNEXT, FIREBASE_INAPP, RBL_PAYOUT, INDIVIDUAL_PAN_KARZA_IN, INDIVIDUAL_PAN_SIGNZY_IN,
//    INDIVIDUAL_ADHAAR_KARZA_IN, INDIVIDUAL_ADHAAR_KARZA_IN_DOWNLOAD, INDIVIDUAL_ADHAAR_SIGNZY_IN,
//    INDIVIDUAL_DL_KARZA_IN, INDIVIDUAL_DL_SIGNZY_IN, INDIVIDUAL_VOTER_KARZA_IN, INDIVIDUAL_VOTER_SIGNZY_IN,
//    EMAIL_GMAIL, EMAIL_TWILIO_SENDGRID, SMS_CONNEXION, INDIVIDUAL_PASSPORT_KARZA_IN, INDIVIDUAL_PASSPORT_SIGNZY_IN,
//    MESSAGING_TELEGRAM, EMAIL_STANDARD, INDIVIDUAL_GST_KARZA_IN, INDIVIDUAL_TAN_KARZA_IN,
//    INDIVIDUAL_PAN_COMM_KARZA_IN, CORPORATE_PAN_KARZA_IN, CORPORATE_PAN_SIGNZY_IN, BHARAT_QR_IN,
//    CORPORATE_GST_SIGNZY_IN, CORPORATE_ROC_SIGNZY_IN, HSM_FUTUREX, HSM_THALES, HSM_INTERNAL, OAUTH2_GOOLGE,
//    EMAIL_RECEIVE_GMAIL, CARD_AUTH_NSDL, INDIVIDUAL_BANK_VERIFY_KARZA_IN, INDIVIDUAL_IFSC_DIGI_IN,
//    HTTPS_INTERNAL_CONVERTER, EMAIL_MAILGUN, CLAMAV_SERVER, INDIVIDUAL_IFSC_KARZA_IN, FASTRACK_MATCH_VERIFICATION,
//
//    FASTRACK_RAMP_VERIFICATION, NPST_EVOK_UPI, INDIVIDUAL_OCR_RETRIEVAL_IN, INTERNAL_CALLBACK, UPI_YESBANK_MGS,
//    ONBOARDING_INTEGRATION_YESBANK, SMS_DIGIMILES, PAYMENT_YESBANK, YES_BANK, CARD_AUTH_RUPAY_WEB,TOUCAN_ISO,
//
//    // need to remove
//    ONBOARDING_INTEGRATION_YESBANK_MGS, ONBOARDING_INTEGRATION_YESBANK_PAYMENTS, NONE, FUTUREX, THALES
//
//}
//
//public enum BankIntegrationEnum {
//    YESBANK
//}
//
//public enum OnBoardingServiceProviderEnum {
//    ONBOARDING_INTEGRATION_YESBANK,
//
//    // need to remove
//    ONBOARDING_INTEGRATION_YESBANK_MGS
//}
//
//public enum MerchantPaymentEnum {
//    PAYMENT_YESBANK,
//
//    // need to remove
//    ONBOARDING_INTEGRATION_YESBANK_PAYMENTS
//}
//
//public enum onboardingEnum {
//    ONBOARDING_INTEGRATION_YESBANK_MGS, MERCHANT_CREATION_TOUCAN, MERCHANT_CREATION_NO_CREATE
//}
//
//public enum FieldTypeEnum {
//
//    STRING, BOOLEAN, TAMOUNT, DATE, TIME, DATETIME, INTEGER, DECIMAL, TUPLOAD
//
//}
//
//public enum ServiceRequestSectionEnum {
//    TERMINAL, MERCHANT, TRAN_N_PYMT, STMT_N_PA, OTHERS, CHAIN_MERC, CHAIN, CHAIN_PYMT, CHAIN_STMT, USER
//}
//
//public enum IntegrationPartnerEnum {
//    IN_PAYNEXT, IN_CCAVENUE, IN_CCAVENUE_NETBANK, IN_NSDL, IN_NPSTEVOK
//}
//
//public enum MerchantSaleFrequency {
//    MINUTES, HOURS, DAILY, MONTHLY, QUARTERLY, HALF_YEARLY, ANNUALLY
//}
//
//public enum RollingReservedFrequency {
//    DAILY, MONTHLY, QUARTERLY, HALF_YEARLY, ANNUALLY
//}
//
//public enum DeliveryStatusEnum {
//    PENDING, COMPLETED, SUCCESSFUL
//}
//
//public enum SimulateQNameEnum {
//    SQ1, SQ2, SQ3, SQ4, SQ5, SQ6, SQ7, SQ8, SQ9, SQ10, SQ11, SQ12
//}
//
//public enum MessagingPlatformEnum {
//    WHATSAPP, TELEGRAM
//}
//
//public enum UserTypeEnum {
//    EXTERNAL_USER, SYSTEM_USER, ALLIANCE_USER
//}
//
//public enum BankStatusEnum {
//    ACTIVE, INACTIVE, NOT_AVAILABLE
//}
//
//public enum NetBankingProviderEnum {
//    CCAVENUE_IN
//}
//
//public enum GPCASecurityUsageEnum {
//    NONE, PRIVATE, SENSITIVE, IMMUTABLE, PASSWORD_EXPORT, CLEAR_KEY_EXPORT, ANONYMOUS_SIGNING
//}
//
//public enum GPSAKeyBlockMethodEnum {
//    MODIFIERVARIANT, ANSI, AKB
//}
//
//public enum GPSAPrimeGenerationIndicatorEnum {
//    STANDARD, STRONGPRIMES
//}
//
//public enum GPGSKeyTypeEnum {
//    NONE, DES_1, DES_2, DES_3, AES_128, AES_192, AES_256, RSA_512, RSA_1024, RSA_2048, RSA_3072, RSA_4096, ECC
//}
//
//public enum MajorKeyEnum {
//    MASTER_FILE_KEY, PLATFORM_MASTER_KEY, FUTURE_TOKEN_KEY
//}
//
//public enum GPGSKeyUsageEnum {
//    Encrypt_Decrypt, Derive, Generate_MAC, VErify_Sign_MAC
//}
//
//public enum GPGSParityEnum {
//    NONE, ODD, EVEN
//}
//
//public enum DESIndicatorEnum {
//    DES, THREE_DES, AES
//}
//
//public enum TPINInputPinBlockFormat {
//    ANSI_Format_0, IBM_3624, PIN_PAD, ISO_FORMAT_1, ISO_FORMAT_3, DUKPT_ANSI, DUKPT_ISO_1, DUKPT_ISO_3
//}
//
//public enum PinBlocFormatEnum {
//    Convert2ANSI, RetainInputformat
//}
//
//public enum ShortUrlCommChannelEnum {
//    EMAIL, TEXT_MESSAGE, WHATSAPP, OTHER
//}
//
//public enum SLADayFrequencyEnum {
//    MINUTES, HOURS, DAYS
//}
//
//public enum FRMFrequencyEnum {
//    MINUTES, HOURS, DAYS
//}
//
//public enum CommChannelEnum {
//    EMAIL, TEXT_MESSAGE, WHATSAPP, OTHER
//}
//
//public enum UserDownloadStatus {
//    PENDING, COMPLETED
//}
//
//public enum OAEPPaddingEnum {
//    SHA_1, SHA_256, SHA_512
//}
//
//public enum PaddingTypeEnum {
//    v1_5method, OAEP
//}
//
//public enum RSAKeyFormatEnum {
//    PKCS_1, PKCS_8
//}
//
//public enum DerivedKeyMethodEnum {
//    DUKPT
//}
//
//public enum KeyTypeConstraintEnum {
//    DES_2, AES128
//}
//
//public enum IncomingPinBlockFormatEnum {
//    Verified, Not_verified, Short_PIN
//}
//
//public enum AuthTrackingStageEnum {
//    PYMT_SESSION_REQUEST, PYMT_SESSION_CREATED, LANDING_TO_PAY, DETAILS_FILLING, SUBMITTED, BROWSER_TIMEOUT,
//    REDIRECT_START, REDIRECT_COMPLETED, APPROVED, REJECTED, ABANDON, HSM_REQ_INIT, HSM_RESP_CNFRM, SWITCH_REQ_INIT,
//    SWITCH_RESP_CNFRM, RESPONSE_SEND_TO_POS, R_HSM_REQ_INIT, R_HSM_RESP_CNFRM, R_SWITCH_REQ_INIT,
//    R_SWITCH_RESP_CNFRM, R_RESPONSE_SEND_TO_POS, R_APPROVED, R_REJECTED, REQUEST_SEND_TO_TOUCAN_SWITCH,
//    R_REQUEST_SEND_TO_TOUCAN_SWITCH, RESPONSE_RECEIVED_FROM_TOUCAN_SWITCH, R_RESPONSE_RECEIVED_FROM_TOUCAN_SWITCH,
//    REQUEST_RECEIVED_FROM_POS, R_REQUEST_RECEIVED_FROM_POS,
//
//    CART_CHECKOUT, PAYMENT_PAGE_REDIRECT, BEGIN_PAYMENT, AUTHORIZATION_REQUESTED, AUTHENTICATION_REQUESTED,
//    AUTHENTICATION_PROCESSED, AUTHORIZATION_CONFIRMED, APPROVED_REJECTED, CART_ABANDON, AUTH_ABANDON,
//    AUTH_INTERNAL_DECLINE, USER_NAVIGATED_OUT_OF_PAYMENT_PAGE, AUTO_TIMEOUT_CART_ABANDON, AUTO_TIMEOUT_AUTH_ABANDON,
//    AUTO_TIMEOUT_AUTH_COMPLETE, CHECK_TRANSACTION_STATUS, SETTLEMENT_TRIGGER, SETTLEMENT_POST_FAIL,
//    SETTLEMENT_POST_PASS, SETTLEMENT_POST_INITIATE, REFUND_INITIATED
//}
//
//public enum FileUploadStatusEnum {
//    OPEN, IN_PROGRESS, CLOSED, VERIFY, VERIFY_COMPLETE, SUBMITTED
//}
//
//public enum DataDownloadStatusEnum {
//    OPEN, IN_PROGRESS, CLOSED, SUBMITTED
//}
//
//public enum DownloadFunctionIdEnum {
//    SR_REPORT, MERCHANT_TRANSACTION_REPORT, MERCHANT_REJECT_TRANSACTION_REPORT, MERCHANT_HOLD_TRANSACTION_REPORT,
//    MERCHANT_HOLD_RELEASE_TRANSACTION_REPORT, MERCHANT_REJECT_RELEASE_TRANSACTION_REPORT, MERCHANT_PAYMENT_REPORT,
//    MERCHANT_REVERSAL_TRANSACTION_REPORT, MERCHANT_PAYOUT_REPORT, MERCHANT_SWITCH_REPORT
//}
//
//public enum TokenKeyUseEnum {
//    PAN, SENSITIVE_DATA
//}
//
//public enum ProxyTypeEnum {
//    /**
//     * Represents a direct connection, or the absence of a proxy.
//     */
//    DIRECT,
//    /**
//     * Represents proxy for high level protocols such as HTTP or FTP.
//     */
//    HTTP,
//    /**
//     * Represents a SOCKS (V4 or V5) proxy.
//     */
//    SOCKS
//}
//
//public enum InterchangeTypeEnum {
//    FIXED, PERCENTAGE, GREATER_OF_BOTH, LESS_OF_BOTH, BOTH
//}
//
//public enum AgentTypeEnum {
//    SALES, SALES_MERCHANT_MGMT, SALES_MERCHANT_VIEW
//}
//
//public enum AuthTxnTypeEnum {
//    SI_REGISTER, SI_DEREGISTER, SI_EDIT, NONE, AUTH, EMI_TXN, REVERSAL
//}
//
///***
// * ISSUING RELATED Start from here
// *
// */
//
//public enum WalletStatusEnum {
//    NEW, ACTIVE, INACTIVE, TO_BE_CLOSED, CLOSED, PURGED
//}
//
//public enum EmploymentTypeEnum {
//    SELF_EMPLOYED, COMPANY
//}
//
//public enum RedirectMode {
//    REDIRECT, POST
//}
//
//public enum paymentphonepe {
//    PAY_PAGE