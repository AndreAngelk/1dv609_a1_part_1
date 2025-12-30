# Table for checking test suite bug coverage

| Test-Version | Correct | NoTrim | ToShort | VeryShort | WrongMsg | MissingLen | MissingNum | AlwaysTrue | WrongHash | BugNumberMustBeLast (MyCustomBug) |
|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| constructorShouldThrowExceptionForShortPasswords | ✅ | ✅ | ❌ | ❌ | ❌ | ❌ | ✅ | ✅ | ✅ | ✅ |
| constructorShouldThrowExceptionForPasswordsWithoutNumber | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ | ✅ |
| constructorShouldTrimWhitespaceForValidPasswords | ✅ | ❌ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| isPasswordSameShouldReturnFalseForDifferentPasswords | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ |
| getPasswordHashShouldReturnExpectedHashForKnownPassword | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ |
| Coverage | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% | 100% |
