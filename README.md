
A curated list of standards, tests and benchmarks that can be used for testing and evaluating dev tools

## Contribution 
1. Add the description of the benchmark to [benchmarks](/benchmarks) directory.
For each benchmark need to create a file in a [TOML](https://toml.io/en/) format.
   
2. Give a good name to your file and add the following content (please note, that all fields are required):
```toml
[general]
    # benchmark name 
    name = ''
	# select the most applicable category (from the [list](https://github.com/analysis-dev/awesome-benchmarks#supported-categories))
    category = ''
	# mark your benchmark with custom tags (your custom OR [existing](https://github.com/analysis-dev/awesome-benchmarks#supported-tags) or add your own)
    tags = ['', '']
	
[info]
    # programming language
    language = ''
    # license used in the project (from the [list](https://github.com/analysis-dev/awesome-benchmarks#supported-licenses))
    license = ''
	# number of tests/cases/scenarios/benchmarks
	scenarios_num = 0
	# free text with a small desciption of the benchmark
    description = ''

[links]
    # the link to the home page of the benchmark
    homepage = ''
    # the link to the source code
    sources = ''
	# the link to the page with documentation 
	documentation = ''
```

3. Create a Pull Request  

4. Validate your input with the following:`gradlew.bat build` (WIN) or `./gradlew build` (LINUX)  (or wait until it will be validated automatically using GitHub Actions CI/CD).
   We validate your input to make this list/library consistent, you won't be able to merge without a validation.
