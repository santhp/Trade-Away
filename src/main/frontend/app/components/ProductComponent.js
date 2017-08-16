import React, { Component } from 'react';

class ProductComponent extends Component{
    constructor(props){
        super(props);
    }
    render(){
        return <div>
        <table style={{width:'100%'}}>
    <tbody>
        <tr>
        <td rowSpan="2" >
            <img src={this.props.product.imageUrl} style={{height:100,width:100}} alt='product'/>
            </td>
            <td >{this.props.product.name}</td>
        <td>Rs. {this.props.product.price}</td>
        <td style={{'textAlign':'right'}}><button>Buy</button></td>
        </tr>
        <tr>
        <td colSpan="3">{this.props.product.description}</td>
        </tr>
        </tbody>
        </table>
        </div>;
    }
}

export default ProductComponent;