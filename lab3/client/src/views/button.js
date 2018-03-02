export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;



			this.innerHTML = `<button>Mine Ore</button>`

			// TODO: add click event to increment counter
			// hint: use "store.dispatch" method (see example component)
			this.querySelector('button').addEventListener('click', () => {
				this.store.dispatch({
					type: 'MINE_BUTTON',
					payload: 1
				});
				console.log('lolworks');
			});
		}
	};
}
