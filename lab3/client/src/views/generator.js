export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			this.id = this.dataset.id;
			console.log('generator created', this.id);
			this.onStateChange = this.handleStateChange.bind(this);
			// TODO: render generator initial view

			// TODO: subscribe to store on change event

			// TODO: add click event

		}
		handleStateChange (newState) {
			console.log('GeneratorComponent#stateChange', this, newState);
			console.log('state change for gen');
			let thisID = this.id;
			const name = store.state.generators[this.id].name;
			let quant = store.state.generators[this.id].quantity;
			const desc = store.state.generators[this.id].description;
			const rate = store.state.generators[this.id].rate;
			const rateForCalc = store.state.generators[this.id].rate;
			const cost = store.state.generators[this.id].cost;
			const baseCost = store.state.generators[this.id].baseCost;
			this.innerHTML = `
			<div class="generator-container">
				<h3>${name}</h3>
				<p>${quant}</p>
				<p>${desc}</p>
				<div class="gen-con-bottom-row-info">
					<p>${rate}</p>
					<button type="button" name="buy-slave" class="buy_button">${cost}</button>
				</div>
			</div>`;

			this.querySelector('button').addEventListener('click', () => {
				console.log(name);
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload: [thisID, cost, baseCost] //tried doing JSON, but couldn't format it correctly
				});
			});

		}

		connectedCallback () {
			console.log('In Callback for gen', this, this.dataset.id);
			//this.innerHTML = `<p>${store.state.generators[this.id].name}</p>`;
			let thisID = this.id;
			const name = store.state.generators[this.id].name;
			let quant = store.state.generators[this.id].quantity;
			const desc = store.state.generators[this.id].description;
			const rate = store.state.generators[this.id].rate;
			const rateForCalc = store.state.generators[this.id].rate;
			const cost = store.state.generators[this.id].cost;
			const baseCost = store.state.generators[this.id].baseCost;
			this.innerHTML = `
			<div class="generator-container">
				<h3>${name}</h3>
				<p>${quant}</p>
				<p>${desc}</p>
				<div class="gen-con-bottom-row-info">
					<p>${rate}</p>
					<button type="button" name="buy-slave" class="buy_button">${cost}</button>
				</div>
			</div>`;

			this.querySelector('button').addEventListener('click', () => {
				console.log(name);
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload: [thisID, cost, baseCost] //tried doing JSON, but couldn't format it correctly
				});
			});



			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			console.log('ExampleComponent#onDisconnectedCallback');
			console.log('disconnectedCallback for gen');
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
