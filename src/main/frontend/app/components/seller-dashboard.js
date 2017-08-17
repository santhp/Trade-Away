import React, {Component} from 'react';
import {browserHistory} from 'react-router';

class SellerDashboard extends Component {

    constructor(props) {
        super(props);
    }

    gotoOrdersPage() {
        browserHistory.push('/orders')
    }

    render() {
        return (

            <div>
                <h2> Dashboard </h2>
                <ul> <li><a href="#" onClick={()=>this.gotoOrdersPage()}>View Orders</a></li> </ul>
            </div>

        );
    }
}

export default SellerDashboard;