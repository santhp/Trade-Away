import React, {Component} from 'react';
import {connect} from 'react-redux';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import '../../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

import * as actions from '../actions';

const products = [{
    orderId: 1001,
    productId: 1,
    name: "IPhone",
    price: 67889,
    address: "Pune",
    status: "Pending"

}, {
    orderId: 1001,
    productId: 2,
    name: "MacBook",
    price: 999999,
    address: "Hyderabad",
    status: "Pending",
}];


class Orders extends Component {

    constructor(props) {
        super(props);
        this.props.getOrders(this.props.user.id);
    }

    render() {
        if (!this.props.orders) {
            return <div>Loading...</div>;
        }

        return (
            <div>
                <h2> Order History </h2>

                <BootstrapTable data={this.props.orders}>
                    <TableHeaderColumn dataField='orderId' isKey>Order Id</TableHeaderColumn>
                    <TableHeaderColumn dataField='productId'>Item Id</TableHeaderColumn>
                    <TableHeaderColumn dataField='name'>Item Name</TableHeaderColumn>
                    <TableHeaderColumn dataField='price'>Amount</TableHeaderColumn>
                    <TableHeaderColumn dataField='address'>Address</TableHeaderColumn>
                    <TableHeaderColumn dataField='status'>Status</TableHeaderColumn>
                </BootstrapTable>

            </div>

        );
    }
}

function mapStateToProps(state) {
    return {
        user: state.data.user,
        orders: state.data.seller_orders
    };
}

export default connect(mapStateToProps, actions)(Orders);
