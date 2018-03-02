export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: render generator initial view
			this.innerHTML = `
				<h3>Slave</h3>
				<p class="count">0</p>
				<p>A run of the mill slave it generates one ore per minute</p>
				<div class="gen-con-bottom-row-info">
					<p>1/60</p>
					<button type="button" name="buy-slave" class="buy_button">10 Ores</button>
				<div>`;
				console.log("lol");
			// TODO: subscribe to store on change event
			this.s
			// TODO: add click event
			this.querySelector('button').addEventListener('click', () => {
				console.log('Generator button click works');
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload: 'meta.'
				})
			});
		}
		handleStateChange (newState) {
			console.log('GeneratorComponent#stateChange', this);
			this.textContent = newState.example;
		}

		connectedCallback () {
			console.log('GeneratorComponent#onConnectedCallback');
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			console.log('GeneratorComponent#onDisconnectedCallback');
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
