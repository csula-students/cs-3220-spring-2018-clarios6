export default function reducer (state, action) {
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;
	case 'MINE_BUTTON':
		state.counter += action.payload;
		return state;
	case 'BUY_GENERATOR':
		state.counter -= action.payload;
		return state;
	default:
		return state;
	}
}
