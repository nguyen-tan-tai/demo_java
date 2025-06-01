package com.example.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-31
 * tags: java, file
 */
class FilesTest {

    @Test
    public void testReadWriteLines() throws IOException {
        Path path = Files.createTempFile(UUID.randomUUID().toString(), ".text");
        try {
            List<String> lines = Arrays.asList("hoge", "fuga");
            Files.write(path, lines);
            Assertions.assertThat(lines).containsExactly("hoge", "fuga");
        } finally {
            Files.delete(path);
        }
    }
}
