REST API приложение, вычисляющее частоту встречи символов 
по заданной строке. Результат отсортирован по
убыванию количества вхождений символа в заданную строку.
Использованы Java 17 и Sping Boot 3.1.3

Способы запуска:
1. Стандартными средствами IntelliJ IDEA
2. `./gradlew build && java -jar ./build/libs/char-counter-1.0.0.jar`
3. Docker - `./gradlew build` or `./gradlew bootJar` + `docker compose up`

Endpoint: POST http://localhost:8080/api/count

Формат входящих параметров: любая непустая строка (plain text).

Формат исходящих параметров: JSON где ключами являются символы,
а значениями - количество вхождений символа в заданную строку.
Символы считаются все - в том числе пробелы, \n и другие.

Пример запроса: `curl -X POST --location "http://localhost:8080/api/count" \
-H "Content-Type: text/plain" \
-d "aaabbbb cccccc"`
