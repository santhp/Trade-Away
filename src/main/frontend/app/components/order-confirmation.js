import React, {Component} from 'react';
import {browserHistory} from 'react-router';

class OrderConfirmation extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (

            <div>
                <h3> Your Order is successfully placed and the seller would process the order shortly </h3>
                <button class="btn btn-default">OK</button>

            </div>
        );
    }
}

export default OrderConfirmation;