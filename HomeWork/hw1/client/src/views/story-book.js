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
			var htmlToReplace =
			`
			<div class="story-book">
				<p>Got Ores? Click on the button to mine one.</p>
			`;

			for(var i = 0 ; i < store.state.story.length ; i++){
				if(store.state.story[i].state == 'visible'){
					const storyToAdd = store.state.story[i].name;
					htmlToReplace += `<p>${storyToAdd}</p>`;
				}
			}
			htmlToReplace += `
				<p>More story to come...</p>
			</div>
			`;
			this.innerHTML = htmlToReplace;
			/*
			this.innerHTML = `
			<div class="story-book">
				<p>Got Ores? Click on the button to mine one.</p>
			`;
			for(var i = 0 ; i < store.state.story.length ; i++){
				if(store.state.story[i].state == 'visible'){
					const storyToAdd = store.state.story[i].name;
					this.innerHTML += `<p>${storyToAdd}</p>`;
				}
			}
			this.innerHTML += `
				<p>More story to come...</p>
			</div>
			`;
			*/
		}

		connectedCallback () {
			this.store.subscribe(this.onStateChange);
			this.innerHTML = `
			<div class="story-book">
				<p>Got Ores? Click on the button to mine one.</p>
				<p>More story to come...</p>
			</div>
			`;
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
