import React, {Component} from 'react';
import {connect} from 'react-redux';

import * as actions from '../actions';

class OrderConfirmation extends Component {

    constructor(props) {
        super(props);
    }

    redirectToDashboard(){
        this.props.cancelCheckout();
    }

    render() {
        return (

            <div>
                <h3> Your Order is successfully placed and the seller would process the order shortly </h3>
                <button className="btn btn-default" onClick={this.redirectToDashboard.bind(this)}>OK</button>

            </div>
        );
    }
}


function mapStateToProps(state) {
    return {
    };
}

export default connect(mapStateToProps, actions)(OrderConfirmation);