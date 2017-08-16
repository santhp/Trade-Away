import React, {Component} from 'react';

class Item extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <div>
            <table style={{width: '100%'}}>
                <tbody>
                <tr>
                    <td rowSpan="2">
                        <img src={this.props.details.imageUrl} style={{height: 100, width: 100}} alt='product'/>
                    </td>
                    <td>{this.props.details.name}</td>
                    <td>Rs. {this.props.details.price}</td>
                    <td style={{'textAlign': 'right'}}>
                        <button>Buy</button>
                    </td>
                </tr>
                <tr>
                    <td colSpan="3">{this.props.details.description}</td>
                </tr>
                </tbody>
            </table>
        </div>;
    }
}

export default Item;