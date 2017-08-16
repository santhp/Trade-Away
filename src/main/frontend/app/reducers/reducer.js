import {
    AUTH_USER,
    UNAUTH_USER,
    AUTH_ERROR,
    CATEGORY_LIST,
    ITEM_LIST
} from '../actions/types';

const INITIAL_STATE = {error: '', message: '', content: '', authenticated: false}

export default function (state = INITIAL_STATE, action) {

    switch (action.type) {
        case AUTH_USER:
            return {...state, error: '', message: '', authenticated: true, user: action.payload};
        case UNAUTH_USER:
            return {...state, authenticated: false};
        case AUTH_ERROR:
            return {...state, error: action.payload};
        case CATEGORY_LIST:
            return {...state, categories: action.payload};
        case ITEM_LIST:
            return {...state, items: action.payload};
    }

    return state;
}
