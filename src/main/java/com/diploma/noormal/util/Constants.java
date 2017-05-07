package com.diploma.noormal.util;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public class Constants {

    public static class ControllerConstants {
        public final static String AMOUNT = "amount";
        public final static String SIZE = "size";
        public final static String CART_SERVICE_IMPL = "cartServiceImpl";
        public static final String ID_PRODUCT = "idProduct";
        public static final String VALUE = "value";
        public static final String PRODUCT_NOT_FOUND = "Product not found!";
        public static final String EXCEPTION = "exception";
        public static final String URL = "url";
        public static final String ERROR_PAGE = "errorPage";
        public static final String ERROR = "error";
        public static final String CHECKBOX_PRODUCER = "checkboxProducer";
        public static final String SELECT_SORT = "selectSort";
        public static final String SELECT_SHOW = "selectShow";
        public static final String FIRST_PRICE = "firstPrice";
        public static final String SECOND_PRICE = "secondPrice";
        public static final String PAGE = "page";
        public static final String ORDER_MODE = "orderMode";
        public static final String USER_FORM = "userForm";
        public static final String INVALID_TOKENS = "Your username or password is invalid.";
        public static final String ORDER_ID = "orderId";
        public static final String DONE_ORDER = "doneOrder";
    }

    public static class ServiceConstants {
        public static final String CURRENT_PAGE = "currentPage";
        public static final String COUNT_OF_LAPTOPS = "countOfLaptops";
        public static final String COUNT_OF_PAGES = "countOfPages";
        public static final String SHOW_COUNT = "showCount";
        public static final String LAPTOP_LIST = "laptopList";
        public static final String PRODUCER_LIST = "producerList";
        public static final String LAPTOPS_ID = "id";
        public static final String DESC = " DESC";
        public static final String ASC = " ASC";
        public static final int DEFAULT_FIRST_PRICE = 0;
        public static final int DEFAULT_SECOND_PRICE = 100000;
        public static final int DEFAULT_SELECT_SHOW = 6;
        public static final int DEFAULT_PAGE = 1;
    }

    public static class ValidatorConstants {
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String NOT_EMPTY = "NotEmpty";
        public static final String SIZE_USER_FORM_USERNAME = "Size.userForm.username";
        public static final String DUPLICATE_USER_FORM_USERNAME = "Duplicate.userForm.username";
        public static final String SIZE_USER_FORM_PASSWORD = "Size.userForm.password";
        public static final String DIFF_USER_FORM_PASSWORD_CONFIRM = "Diff.userForm.passwordConfirm";
        public static final String PASSWORD_CONFIRM = "passwordConfirm";
    }

    public static final String USER = "user";
    public static final String USER_AVATAR = "userAvatar";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PASS = "pass";
    public static final String PASSWORD = "password";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String CAPTCHA = "captcha";
    public static final String CAPTCHA_SCOPE = "captchaScope";
    public static final String SCOPE = "scope";
    public static final String CAPTCHA_CODE = "codeCaptcha";
    public static final String TIME = "time";
    public static final String SESSION = "session";
    public static final String COOKIE = "cookie";
    public static final String HIDDEN = "hidden";
    public static final String CAPTCHA_INPUT = "captcha_input";
    public static final String WRONG_NUMBERS = "Wrong numbers";
    public static final String EMAIL_ALREADY_EXIST = "This email is already exist!";
    public static final String REGISTRATION_SERVLET = "registration_servlet";
    public static final String LOGIN_SERVLET = "login_servlet";
    public static final String ERROR_TIME_OUT_JSP = "errorTimeOut.jsp";
    public static final String ACCOUNT_JSP = "account.jsp";
    public static final String INDEX_JSP = "index.jsp";
    public static final String REGISTER_JSP = "register.jsp";
    public static final String PRODUCTS_JSP = "products.jsp";
    public static final String FORM_BEAN = "formBean";
    public static final String ERRORS = "errors";
    public static final String USER_SERVICE = "userService";
    public static final String PRODUCT_SERVICE = "productService";
    public static final String FORM_BEAN_SERVICE = "formBeanService";
    public static final String ORDER_SERVICE = "orderService";
    public static final String AVATARS_PATH = "avatars";
    public static final String WRONG_EMAIL_OR_PASSWORD = "wrongEmailOrPassword";
    public static final String SIMPLE_WRONG_EMAIL_OR_PASSWORD = "Wrong email or password";
    public static final String DATA_SOURCE_LOOKUP = "java:comp/env/jdbc/web_store";
    public static final String SIMPLE_TRANSACTIONAL_ERROR = "transactionalError";
    public static final String TRANSACTIONAL_ERROR = "IT IS SERVER ERROR. PLEASE, TRY AGAIN LATER.";

    public static final String CATEGORY_LIST = "categoryList";
    public static final String PRODUCT_PRODUCER = "product.producer";
    public static final String PRODUCT_COST = "product.cost";


    public static final String ORDER_BY = "orderBy";
    public static final String LIMIT = "showCount";

    public static final String PHOTO = "photo";
    public static final String PNG = ".png";

    public static final String CATALOG_FILTER_SERVICE = "catalogFilterService";

    public static final String WHERE_SQL = " WHERE ";
    public static final String SIMPLE_AND_SQL = "AND (";
    public static final String AND_SQL = ") AND (";
    public static final String LIMIT_SQL = " LIMIT ";
    public static final String ORDER_BY_SQL = "ORDER BY ";
    public static final String OR_SQL = " OR ";


    public static final String CART = "cart";

    public static final String VALUE = "value";
    public static final String REDIRECT_PAGE = "redirectPage";
    public static final String CREATE_ORDER_JSP = "createOrder.jsp";
    public static final String CONFIRM_ORDER_JSP = "confirmOrder.jsp";
    public static final String DONE_ORDER_JSP = "doneOrder.jsp";
    public static final String TYPE_PAYMENT = "typePayment";
    public static final String CARD = "card";
    public static final String LAST_ORDER_ID = "lastOrderId";
    public static final String LOCALE = "locale";
    public static final String STORAGE = "storage";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String GZIP = "gzip";
    public static final String TEXT = "text";
    public static final String ACCESS_DENIED = "ACCESS DENIED";
    public static final String PATH = "path";
    public static final int CODE_ERROR_403 = 403;


    public static final String GET_ALL_LAPTOPS = "SELECT * FROM `laptops`";
    public static final String GET_ALL_PRODUCERS = "SELECT * FROM producer";
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM category";
    public static final String GET_LAPTOP_BY_ID = "SELECT * FROM `laptops` WHERE `laptops`.id = ?";
}
