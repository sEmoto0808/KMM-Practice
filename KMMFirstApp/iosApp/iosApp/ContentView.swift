import SwiftUI
import shared

struct ContentView: View {
	let greeting = Greeting()

    @State var greet = "Loading"

	var body: some View {
		Text(greet)
            .onAppear(perform: load)
	}

    func load() {
        greeting.getHtml { result, error in
            if let result = result {
                greet = result
            } else if let error = error {
                greet = "Error: \(error)"
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
