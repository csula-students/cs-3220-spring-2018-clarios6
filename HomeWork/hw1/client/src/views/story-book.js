export default function (store) {
	return class StoryBookComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			// TODO: initial DOM rendering of story itself

			this.onStateChange = this.handleStateChange.bind(this);
		}

		handleStateChange (newState) {
			// TODO: display story based on the state "resource" and "stories"
		}

		connectedCallback () {
			this.store.subscribe(this.onStateChange);
			this.innerHTML = `
			<div class="story-book">
				<p>Got Ores? Click on the button to mine one.</p>
				<p>Your ores are pretty valuable</p>
				<p>O is for ores, and ores are pretty neat.</p>
				<p>More story to come...</p>
			</div>
			`;
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
