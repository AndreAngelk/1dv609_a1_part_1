# Table for checking test suite bug coverage

Legend: ✅ = PASSED, ❌ = FAILED

| SUT | Test | Correct SSN | NoTrim | NoLenCheck | NoLuhn | WrongYear | Correct Helper | WrongLen | Month0 | Day<31 | FmtTrue | FmtFalse | MessyLuhn | Day0 (MyCustomBug) |
|---|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| SwedishSocialSecurityNumber | constructorShouldTrimWhitespaceForValidInput | ✅ | ❌ | ✅ | ✅ | ✅ |  |  |  |  |  |  |  |  |
| SwedishSocialSecurityNumber | constructorShouldThrowExceptionForWrongLength | ✅ | ✅ | ❌ | ✅ | ✅ |  |  |  |  |  |  |  |  |
| SwedishSocialSecurityNumber | constructorShouldThrowExceptionWhenLuhnFails | ✅ | ✅ | ✅ | ❌ | ✅ |  |  |  |  |  |  |  |  |
| SwedishSocialSecurityNumber | getYearShouldReturnFirstTwoDigitsForValidSSN | ✅ | ✅ | ✅ | ✅ | ❌ |  |  |  |  |  |  |  |  |
| SSNHelper | isCorrectLengthShouldReturnFalseFor12Characters |  |  |  |  |  | ✅ | ❌ | ❌ | ✅ | ✅ | ✅ | ✅ | ✅ |
| SSNHelper | isValidMonthShouldReturnFalseFor00 |  |  |  |  |  | ✅ | ✅ | ❌ | ✅ | ✅ | ✅ | ✅ | ✅ |
| SSNHelper | isValidDayShouldReturnTrueFor31 |  |  |  |  |  | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ | ✅ | ✅ |
| SSNHelper | isCorrectFormatShouldReturnFalseWhenHyphenMissing |  |  |  |  |  | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ | ✅ |
| SSNHelper | isCorrectFormatShouldReturnTrueForValidPattern |  |  |  |  |  | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ |
| SSNHelper | luhnIsCorrectShouldReturnTrueForKnownValidSSN |  |  |  |  |  | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ |
| SSNHelper | isValidDayShouldReturnFalseFor00 |  |  |  |  |  | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ |
| Coverage | (statement/line) | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% |