import React, {Component} from 'react';
import axios from 'axios';

class Checkout extends Component{
    constructor(props){
        super(props);
        this.state={
            productId:props.product.id,
            qty:1,
            deliveryAddress:props.address
        };
    }

    onPlaceOrder(e){
        e.preventDefault();

        var apiBaseUrl = "http://localhost:8090/order/";
        var self = this;
        var payload= {
            "productId":this.state.productId,
            "qty":this.state.qty,
            "deliveryAddress":this.state.deliveryAddress
        };

        axios.post(apiBaseUrl, payload)
            .then(function (response) {
                console.log(response);
                if(response.status == 201){
                    console.log("Order placed sucessfully.");
                    alert("Order placed successfully.")
                }
                else {
                    console.log("Error creating order...");
                    alert("Order creation failed...");
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render(){
        var qty = this.props.product.qty;
        var options = [];
        for (var i = 0; i < qty; i++) {
            options.push(<option key={i} value={i+1}>{i+1}</option>);
        }

        return <div>
        <h2 style={{'textAlign':'center'}}>Checkout</h2>
        <div>

        <table width="500">
            <tbody>
            <tr>
            <td style={{'textAlign':'left'}}>Item Selected</td>
        <td>:</td>
        <td>{this.props.product.name}</td>
        </tr>
        <tr>
        <td style={{'textAlign':'left'}}>Quantity</td>
        <td>:</td>
        <td><select onChange={(event)=>this.setState({qty:event.target.value})}>{options}</select></td>
        </tr>
        <tr>
        <td style={{'textAlign':'left'}}>Delivery Address</td>
        <td>:</td>
        <td><textArea value={this.props.address}
        onChange = {(event,newValue) => this.setState({deliveryAddress:newValue})}></textArea> </td>
        </tr>
        <tr>
        <td colSpan="3" style={{'textAlign':'center'}}>
    <button onClick={this.onPlaceOrder.bind(this)}>Place Order</button>
        <button>Cancel</button></td>
        </tr>
        </tbody>
        </table>
        </div>
        </div>;
    }
}

export default Checkout;