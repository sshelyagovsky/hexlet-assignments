setup:
	./gradlew wrapper --gradle-version 8.3
	./gradlew build

app:
	./gradlew run

clean:
	./gradlew clean

build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain checkstyleTest

dev: app

reload-classes:
	./gradlew -t classes

install:
	./gradlew installDist

test:
	./gradlew test

check-java-deps:
	./gradlew dependencyUpdates -Drevision=release

.PHONY: build
