# BudgetRPG

Detta är en komplett Spring Boot-applikation (Java 21) med en statisk frontend för BudgetRPG. Klona eller öppna som Maven-projekt i IntelliJ och starta `BudgetRpgApplication`. Frontend serveras som statiska filer under `src/main/resources/static`.

## Starta

1. Öppna projektet i IntelliJ eller valfri Java IDE. Se till att du har JDK 21 installerat.
2. Kör klassen `com.madprints.budgetrpg.BudgetRpgApplication`. Servern startar på port 8081.
3. Navigera till `http://localhost:8081` i webbläsaren. Frontend laddas och du kan börja använda appen.
4. H2 Console nås via `http://localhost:8081/h2-console` med JDBC URL `jdbc:h2:mem:budgetrpg`. User `sa`, inget lösenord.

## API

- POST `/api/budget/calculate` – skicka inkomst, sparmål och utgifter för att få budgetresultat.
- `/api/quests` – CRUD för quests.

Valideringsfel returneras med 422 och ett JSON-fält `violations`.
