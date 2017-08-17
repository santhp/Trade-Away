import React, {Component} from 'react';
import {connect} from 'react-redux';

import * as actions from '../actions';

class BuyButton extends Component {
    constructor(props) {
        super(props);
    }

    isAvailable() {
        return this.props.sellers.reduce(function (quantity, seller) {
            return quantity + seller.quantity
        }, 0) > 0
    }

    render() {
        if (this.isAvailable()) {
            return <button onClick={this.checkout.bind(this)}>Buy</button>;
        } else {
            return <button disabled="disabled" title="Out of stock!" className="Input-Disabled">Buy</button>
        }
    }
}

class Item extends Component {
    constructor(props) {
        super(props);
    }

    isQuantityAvailable() {
        return this.props.details.sellerDto.reduce(function (quantity, seller) {
            return quantity + seller.quantity
        }, 0) > 0
    }

    checkout() {
        var details = this.props.details;
        var data = {
            productId: details.productId,
            productName: details.name,
            sellerId: details.sellerDto[0].sellerId,
            buyerId: this.props.userId,
            imageUrl: details.imageUrl
        }
        this.props.buyItem(data);
    }

    renderButton() {
        if (this.isQuantityAvailable()) {
            return <button onClick={this.checkout.bind(this)}>
                <span className="glyphicon glyphicon-shopping-cart"/> Buy
            </button>;
        } else {
            return <button disabled="disabled" title="Out of stock!" className="Input-Disabled">
                <span className="glyphicon glyphicon-shopping-cart"/> Buy
            </button>
        }
    }

    render() {
        return (<div>
            <div className="panel panel-default">
                <div className="panel-body">
                    <div className="row">
                        <div className="col-md-4">
                            <img height="150" width="150" src={this.props.details.imageUrl}/>
                        </div>
                        <div className="col-md-8">
                            <div className="row">
                                <div className="col-md-4">{this.props.details.name}</div>
                                <div className="col-md-4">&#8377; {this.props.details.price}</div>
                                <div className="col-md-4 text-right">
                                    {this.renderButton()}
                                </div>
                            </div>
                        </div>
                        <div className="col-md-8" style={{marginTop: 20}}>
                            <div className="row">
                                <div className="col-md-6">{this.props.details.description}</div>
                                <div className="col-md-6 text-right">{this.props.details.sellerDto.length - 1} more
                                    sellers
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>);
    }
}


function mapStateToProps(state) {
    return {
        userId: state.data.user.id
    };
}

export default connect(mapStateToProps, actions)(Item);
