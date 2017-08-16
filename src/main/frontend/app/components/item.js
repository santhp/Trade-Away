import React, {Component} from 'react';

class Item extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (<div>
            <div className="panel panel-default">
                <div className="panel-body">
                    <div className="row">
                        <div className="col-md-4">
                            <img height="100" width="100" src={this.props.details.imageUrl}/>
                        </div>
                        <div className="col-md-8">
                            <div className="row">
                                <div className="col-md-4">{this.props.details.name}</div>
                                <div className="col-md-4">Rs. {this.props.details.price}</div>
                                <div className="col-md-4 text-right">
                                    <button>Buy</button>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6">{this.props.details.description}</div>
                                <div className="col-md-4 text-right">Seller</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>);
    }
}

export default Item;