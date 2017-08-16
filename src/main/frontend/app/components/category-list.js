import React, { Component } from 'react';
import {connect} from 'react-redux';

class CategoryList extends Component{
    constructor(props){
        super(props);
    }
    render(){
        if(this.props.user.role === 'buyer')
            return <div><h1>Categories1</h1></div>;
        else
            return <div>Seller Landing Page</div>
    }
}


function mapStateToProps(state) {
    return {user: state.auth.user};
}



export default connect(mapStateToProps)(CategoryList);
