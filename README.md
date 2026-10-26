# jj-dojo

A practice repository for the TechExchange on Jujutsu (jj). Three labs take
you from your first signed commit to resolving conflicts and undoing
mistakes, all on a small Kotlin program that greets people.

| Path                             | What it is                                     |
| -------------------------------- | ---------------------------------------------- |
| `apprentices/`                   | One file per apprentice, added in Lab 1        |
| `src/main/kotlin/dojo/Greet.kt`  | The `greet` function the labs change           |
| `src/main/kotlin/dojo/Main.kt`   | The command: `gradle run --args=Lena`          |
| `src/test/kotlin/dojo/`          | Tests with `kotlin.test` on JUnit 6            |
| `.github/workflows/ci.yml`       | Lints and tests every pull request             |

## Before you start

Install jj 0.46 or newer, git 2.42 or newer, and `gh`, and sign commits with
your SSH key, as the setup slides show. Then clone over HTTPS:

```sh
jj git clone https://github.com/nca-apprentices/jj-dojo
```

## Rules on main

- Changes arrive through a pull request with one approval.
- Every commit on every branch carries a verified signature. GitHub rejects
  a push with an unsigned commit.
- History stays linear. Pull requests merge as one squashed commit through
  the merge queue.
- CI runs `Lint and test` on each pull request and each merge group.

After your pull request merges, `jj git fetch` brings the squashed commit.
Your own change stays in `jj log` beside it, because the squash created a
new commit. Remove it with `jj abandon <change ID>`.

## Labs

### Lab 1: get to Verified

1. Add `apprentices/<your GitHub login>.md` with your name and year.
2. `jj commit -m "docs: add <your name>"`
3. `jj git push -c @-`, then `gh pr create --head push-<change ID> --fill`.
4. The pull request shows the green Verified badge on your commit.

### Lab 2: review each other

1. Each of you adds one function to `Greet.kt` and a test for it.
2. Push, open the pull request, and request your partner as reviewer.
3. Reviewer: leave two comments. Author: `jj new <change ID>`, fix, then
   `jj squash` and `jj git push`.
4. Merge one pull request. The other author runs `jj git fetch`, then
   `jj rebase -o main`, resolves any conflict, and pushes.

### Lab 3: break it on purpose

This lab stays on your machine.

1. `jj new main`, change line 3 of `Greet.kt`, `jj commit -m A`.
2. `jj new main`, change the same line differently, `jj commit -m B`.
3. `jj rebase -s <A> -o <B>`: a conflict, and nothing stops.
4. `jj log -r 'conflicts()'` finds it.
5. `jj new <A>`, fix the markers, `jj squash`.
6. `jj abandon` the wrong change, then get it back with `jj op log` and
   `jj undo`.

## Development

[mise](https://mise.jdx.dev) installs the pinned JDK, Gradle, ktlint, and
actionlint.

```sh
mise install
gradle check
ktlint
```

`jj fix` formats every change in your stack. Add this to the repository's
jj config with `jj config edit --repo`:

```toml
[fix.tools.ktlint]
command = ["ktlint", "--stdin", "--format", "--log-level=none"]
patterns = ["glob:'**/*.{kt,kts}'"]
```

## License

[Apache-2.0](LICENSE)
