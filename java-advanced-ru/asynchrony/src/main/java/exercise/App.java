package exercise;


import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {
    // BEGIN
    public static CompletableFuture<String> unionFiles(String srcFilePath1, String srcFilePath2, String outFile) {

        CompletableFuture<String> fileData1 = CompletableFuture.supplyAsync(() -> {

            var fileData = "";

            try {

                fileData = Files.readString(getNormilizedPath(srcFilePath1));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return fileData;
        });

        CompletableFuture<String> fileData2 = CompletableFuture.supplyAsync(() -> {

            var fileData = "";

            try {

                fileData = Files.readString(getNormilizedPath(srcFilePath2));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return fileData;
        });

        CompletableFuture<String> splitFiles = fileData1.thenCombine(fileData2, (fData1, fData2) -> {

            var splitData = fData1 + fData2;

            try {
                Files.write(Paths.get(outFile), splitData.getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e) {

                throw new RuntimeException(e);
            }
            return "Split file was successful";

        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });

        return splitFiles;
    }

    public static CompletableFuture<Long> getDirectorySize(String path) throws IOException {

        CompletableFuture<Long> folderSize = CompletableFuture.supplyAsync(() -> {
            Long size;

            try {
                size = Files.walk(getNormilizedPath(path), 1)
                        .filter(p -> p.toFile().isFile())
                        .mapToLong(p -> p.toFile().length())
                        .sum();

                return size;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });

        return folderSize;
    }

    public static Path getNormilizedPath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result =
                App.unionFiles("src/main/resources/file1.txt",
                        "src/main/resources/file2.txt",
                        "src/main/resources/outFile.txt");
        result.get();

        CompletableFuture<Long> folderSize = App.getDirectorySize("src/main/resources");
        System.out.println("Split files and calculate folder finish!");
        System.out.println(folderSize.get() + "B");
        // END
    }
}

