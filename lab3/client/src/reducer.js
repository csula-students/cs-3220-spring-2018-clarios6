import constants from './constants';

export default function reducer (state, action) {
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;
	case 'MINE_BUTTON':
		state.counter += action.payload;
		return state;
	case 'BUY_GENERATOR':
		if(/*state.counter >= action.payload[2]*/ true){
			var cID = action.payload[0];
			var cCurCost = action.payload[1];
			var cBaseCost = action.payload[2];
			var growth = 1 + 0.5;
			state.counter -= cCurCost; //this is the cost
			state.generators[cID].quantity += 1;
			var quantity = state.generators[cID].quantity;
			state.generators[cID].cost = cBaseCost * Math.pow(growth, quantity);
			//console.log('cost is',  this.default.growthRatio);
			console.log('can buy Generator');
		} else {
			console.log('cant buy generator');
		}
		return state;
	default:
		return state;
	}
}
