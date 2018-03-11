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
		return state;
	case 'INCREMENT':
		console.log('Incrementing by', action.payload);
		state.counter += action.payload;
		return state;
	default:
		return state;
	}
}
