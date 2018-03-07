export default function (store) {
	return class CounterComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			console.log('CounterComponent Created');
			// TODO: render counter inner HTML based on the store state
			this.textContent = this.store.state.counter;
			this.onStateChange = this.handleStateChange.bind(this);
		}

		handleStateChange (newState) {
			console.log('CounterComponent#stateChange', this, newState);
			// TODO: update inner HTML based on the new state
			this.innerHTML = `<p>Ores: ${store.state.counter}</p>`;
			console.log('updated counter');
		}

		connectedCallback () {
			console.log(this.onStateChange);
			this.innerHTML = `<p>Ores: 0</p>`;
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
