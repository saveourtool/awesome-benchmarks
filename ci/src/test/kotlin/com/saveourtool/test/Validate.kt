package com.saveourtool.test

import com.akuleshov7.ktoml.exceptions.KtomlException
import org.junit.jupiter.api.Test
import java.io.File
import com.akuleshov7.ktoml.file.TomlFileReader
import kotlinx.serialization.serializer
import org.junit.jupiter.api.fail

class Validate {
    @Test
    fun validateBenchmarks() {
        File("../benchmarks/").walk().forEach {
            if (it.isFile) {
                try {
                    val resultFromString = TomlFileReader.decodeFromFile<BenchmarkInfo>(serializer(), it.absolutePath)
                    validate(resultFromString)
                } catch (e: KtomlException) {
                    fail(
                        "Invalid example was added to the list!" +
                                " Cannot parse \"${it.name}\" due to a parsing exception: \n ${e.localizedMessage} "
                    )
                }
            }
        }
    }

    private fun validate(info: BenchmarkInfo) {
        assert(info.general.name.isNotEmpty()) { "Name of your tool ([general] name) cannot be empty" }
        assert(info.general.tags.isNotEmpty()) { "You should provide at least one tag for your tool in [general] tags" }

        assert(info.info.language.isNotEmpty()) { "You should specify the main programming language that is used in the benchmark/framework/standard" }
        assert(licensesList.contains(info.info.license)) { "Please select the license from the existing list. If you haven't found it in the list - please add it here: https://github.com/analysis-dev/awesome-benchmarks/blob/main/ci/src/test/kotlin/com/saveourtool/test/LicensesList.kt" }
        assert(info.info.scenarios_num != 0L) { "Please count and specify the number of scenarios ([info] scenarios_num) that you have in your project, it cannot be 0." }
        assert(info.info.description.isNotEmpty() && info.info.description.length > 50) { "Please provide some description in [info] description, it cannot be less than 50 symbols" }

        assert(info.links.homepage.isNotEmpty()) { "Link to the homepage cannot be empty" }
        assert(info.links.sources.isNotEmpty()) { "Please provide the link to the sources of benchmark" }
        assert(info.links.documentation.isNotEmpty()) { "You need to provide documentation of the benchmark" }
    }
}
