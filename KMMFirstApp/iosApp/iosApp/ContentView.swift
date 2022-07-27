import SwiftUI
import shared

struct ContentView: View {
	let greeting = Greeting()
	let githubApi = GithubApi()

    @State var greet = "Loading"
    @State var repos: [Repository] = []

	var body: some View {
        VStack {
            Text(greet)

            List(repos, id: \.self) { repo in
                Text(repo.name)
            }
        }
        .onAppear(perform: load)
	}

    func load() {
        githubApi.fetchRepos { result, error in
            if let result = result {
                repos = result
                greet = "Success"
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
