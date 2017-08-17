import React, {Component} from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import '../../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

const products = [{
    orderId: 1001,
    productId:1,
    name: "IPhone",
    price: 67889,
    address: "Pune",
    status: "Pending"

}, {
    orderId: 1001,
    productId:2,
    name: "MacBook",
    price: 999999,
    address: "Hyderabad",
    status: "Pending",
}];

class Orders extends Component {

    constructor(props) {
        super(props);
    }


    render() {
        return (

            <div>
                <h2> Order History </h2>

                <BootstrapTable data={ products }>
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

export default Orders;