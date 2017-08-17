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
                            <div className="col-md-4">
                                <div className="row">
                                    <label>Item Selected</label>
                                    {this.props.details.productName}
                                </div>
                                <div className="row">
                                    <label>Quantity</label>
                                    <select
                                        onChange={(event) => this.setState({qty: event.target.value})}>{options}</select>
                                </div>
                                <div className="row">
                                    <label>Delivery Address</label>
                                    <textArea value={this.props.address}
                                              onChange={(event, newValue) => this.setState({deliveryAddress: newValue})}></textArea>
                                </div>
                            </div>

                            <div className="col-md-2">
                                <img height="110" width="110" src={this.props.details.imageUrl}/>
                            </div>
                        </div>

                        <div className="row" style={{marginTop: 10}}>
                            <div className="col-md-4"></div>
                            <button className="btn btn-success" onClick={this.onPlaceOrder.bind(this)}>Place Order
                            </button>
                            <button className="btn btn-danger" onClick={this.onCancelOrder.bind(this)}>Cancel</button>

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