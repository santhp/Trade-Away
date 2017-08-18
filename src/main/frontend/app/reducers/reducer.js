import {
    AUTH_USER,
    UNAUTH_USER,
    AUTH_ERROR,
    CATEGORY_LIST,
    ITEM_LIST,
    SELLER_ORDERS,
    CANCEL_CHECKOUT,
    BUY_ITEM,
    PLACE_ORDER,
    PLACE_ORDER_ERROR
} from '../actions/types';

const INITIAL_STATE = {error: '', message: '', content: '', authenticated: false}

export default function (state = INITIAL_STATE, action) {

    switch (action.type) {
        case AUTH_USER:
            return {
                ...state,
                error: '',
                message: '',
                authenticated: true,
                user: action.payload,
                categories: '',
                items: ''
            };
        case UNAUTH_USER:
            return {...state, authenticated: false, user: ''};
        case AUTH_ERROR:
            return {...state, error: action.payload};
        case CATEGORY_LIST:
            return {...state, categories: action.payload, items: ''};
        case ITEM_LIST:
            return {...state, items: action.payload};
        case SELLER_ORDERS :
            return {...state, seller_orders: action.payload};
        case BUY_ITEM:
            return {...state, checkout_details: action.payload};
        case CANCEL_CHECKOUT:
            return {...state, checkout_details:'',global_alert:''};
        case PLACE_ORDER:
            return {...state, checkout_details:'', order_response:action.payload, global_alert:''};
        case PLACE_ORDER_ERROR:
            return {...state, checkout_details:'', order_response:'', global_alert:"Success"};
    }

    return state;
}
