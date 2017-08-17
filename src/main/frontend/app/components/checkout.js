import React, {Component} from 'react';
import {connect} from 'react-redux';

import * as actions from '../actions';

class Checkout extends Component {
    constructor(props) {
        super(props);
    }

    onPlaceOrder(e) {
        var payload = {
            "productId": this.state.productId,
            "qty": this.state.qty,
            "deliveryAddress": this.state.deliveryAddress
        };
    }

    onCancelOrder(e) {
        this.props.cancelCheckout();
    }


    render() {
        var options = [];
        for (var i = 0; i < 10; i++) {
            options.push(<option key={i} value={i + 1}>{i + 1}</option>);
        }

        return <div>
            <h2 style={{'textAlign': 'center'}}>Checkout</h2>
            <div>
                <div className="panel panel-default">
                    <div className="panel-body">
                        <div className="row">

                            <div className="col-md-2">
                                <img height="110" width="110" src={this.props.details.imageUrl}/>
                            </div>

                            <div className="col-md-10">
                                <div className="row">
                                    <label className="control-label col-sm-2">Item Selected</label>
                                    <div className="col-sm-10">{this.props.details.productName}</div>
                                </div>
                                <div className="row">
                                    <label className="col-sm-2 control-label">Quantity</label>
                                    <select className="form-control" style={{width: 100}}
                                            onChange={(event) => this.setState({qty: event.target.value})}>{options}</select>

                                </div>
                                <div className="row" style={{paddingTop: 10}}>
                                    <label className="control-label col-sm-2">Delivery Address</label>
                                    <textArea value={this.props.address} className="form-control" style={{width: 300}}
                                              onChange={(event, newValue) => this.setState({deliveryAddress: newValue})}></textArea>
                                </div>
                            </div>
                        </div>

                        <div className="btn-toolbar" style={{marginTop: 10}}>
                            <div className="col-md-3"></div>
                            <button className="btn btn-default" onClick={this.onPlaceOrder.bind(this)}>
                                <span className="glyphicon glyphicon-shopping-cart"/> Place Order
                            </button>
                            <button className="btn" onClick={this.onCancelOrder.bind(this)}>Cancel</button>

                        </div>
                    </div>


                </div>
            </div>
        </div>;
    }
}

function mapStateToProps(state) {
    return {
        details: state.data.checkout_details
    };
}

export default connect(mapStateToProps, actions)(Checkout);