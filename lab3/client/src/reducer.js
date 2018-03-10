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
		console.log('reducer for gen');
		var growth = 1 + 0.05;
		for (var i = 0 ; i < state.generators.length ; i++){
			console.log('in gen loop', i);
			console.log(state.generators[i].name);
			console.log(action.payload.name);
			if(state.generators[i].name == action.payload.name){
				console.log('found gen');
				var cost = (state.generators[i].baseCost * Math.pow(growth, state.generators[i].quantity)).toFixed(2) / 1;
				console.log(cost);
				state.counter = (state.counter - cost).toFixed(2) / 1;
				state.generators[i].quantity += action.payload.quantity;
				break;
			}
		}



		/*
		if(state.counter >= action.payload[2] true){
			const genName = action.payload.name;
			const genQuan = action.payload.quantiy;

			for(var i = 0 ; i < state.generators.length; i++){
				if(state.generators[i].name === genName){

					state.counter = state.counter - ((state.generators[i].baseCost * Math.pow(0.05, action.quantity)).toFixed(2) / 1);
					state.generators[i].quantiy += 1;
				}

			}

			var cID = action.payload[0];
			var cCurCost = action.payload[1];
			var cBaseCost = action.payload[2];
			var growth = 1 + 0.05;
			state.counter -= cCurCost; //this is the cost
			state.generators[cID].quantity += 1;
			var quantity = state.generators[cID].quantity;
			state.generators[cID].cost = (cBaseCost * Math.pow(growth, quantity)).toFixed(2) / 1;
			//console.log('cost is',  this.default.growthRatio);
			console.log('can buy Generator');

		} else {
			console.log('cant buy generator');
		}
		*/
		return state;
	default:
		return state;
	}
}
