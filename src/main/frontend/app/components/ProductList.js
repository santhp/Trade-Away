import React, { Component } from 'react';
import ProductComponent from './ProductComponent'


class ProductList extends Component{
    constructor(props){
        super(props);
    }
    render(){
        return <div>Category: {this.props.category.name}
        {this.props.category.products.map((p)=><ProductComponent product={p} key={p.id}/>)}
        </div>;
        }
    }

    export default ProductList;