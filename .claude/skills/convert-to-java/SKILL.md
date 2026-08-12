---
name: convert-to-java
description: Convert Kotlin CSES solutions in src/main/kotlin/solutions to Java equivalents in src/main/kotlin/solutionsJava. Use when the user asks to "convert" a Kotlin solution to Java, or to convert all uncommitted/new Kotlin solutions to Java.
---

# Convert Kotlin solutions to Java

Converts files from `src/main/kotlin/solutions/*.kt` into Java equivalents in
`src/main/kotlin/solutionsJava/*.java`.

## Scope

- If the user names a specific file, convert only that one.
- If the user says something like "convert all uncommitted kotlin code" or gives no
  specific file, find candidates by:
  1. `git status --short` for new/modified `.kt` files under `src/main/kotlin/solutions/`.
  2. Any `.kt` file in `src/main/kotlin/solutions/` whose corresponding
     `src/main/kotlin/solutionsJava/<Name>.java` is missing or older/out of sync.
- Confirm the list with the user before converting more than one file if it's not obvious
  from context.

## Conversion rules

1. **Logic stays as-is.** Translate the Kotlin line-by-line/structure-by-structure into
   Java — same algorithm, same variable names, same control flow, same helper function
   split. Do not "improve", refactor, or restructure the logic.
2. **No Stream APIs.** Never use `Arrays.stream`, `.stream()`, `.mapToInt`, lambdas passed
   into stream pipelines, etc. Use plain loops and imperative Java instead. This applies
   even when the Kotlin uses functional-style collection operations (`.map`, `.filter`,
   `.sorted`, ...) — translate those to an equivalent loop, not a Java stream pipeline.
   - `numbers.sorted()` → copy the array/list, then `Arrays.sort(...)`.
   - `split(" ").map(String::toInt)` → split into a `String[]`, then loop and
     `Integer.parseInt(...)` into an `int[]`.
3. **No package declaration.** CSES submissions are single files with no `package` line.
   Do not add `package solutionsJava;` (or any package) to the output file, and if
   converting a file that already has one, strip it.
4. Keep the file name matching the class name (`<Name>.java` containing
   `public class <Name>`), placed directly in `src/main/kotlin/solutionsJava/`.
5. Preserve comments from the Kotlin source that explain non-obvious logic (e.g. a
   one-line comment describing the algorithm/approach). Don't add new explanatory
   comments beyond what's needed.
6. Use `Scanner` for input in the same shape as the Kotlin version (same read order/calls
   — e.g. `nextInt()` then `nextLine()` then a line split by spaces), matching existing
   Java solutions' input-reading style in the folder for consistency.

## After converting

1. Compile the file standalone to check it's valid, e.g.:
   `javac -d <scratch-dir> src/main/kotlin/solutionsJava/<Name>.java`
2. Run it against a small sanity input mirroring the Kotlin version's expected input
   format and sanity-check the output.
3. Report which file(s) were converted; do not commit unless the user asks.
