package net.home.oleksin.calculator.parser;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ParserTest {
    private Parser parser;

    @Test
    @DisplayName("should return empty object")
    public void shouldReturnEmpty() {
        parser = new Parser(" ");
        assertThat(Optional.empty(), is(parser.iterator().next()));
    }

    @Test
    @DisplayName("should Return IllegalStateException")
    public void shouldReturnIllegalStateException() {
        parser = new Parser("2a");
        Assertions.assertThrows(IllegalStateException.class, ()->parser.iterator().next());
    }

    @Test
    @DisplayName("should Return NoSuchElementException")
    public void shouldReturnNoSuchElementException() {
        parser = new Parser("a");
        Assertions.assertThrows(NoSuchElementException.class, ()->parser.iterator().next());
    }

    @Test
    @DisplayName("should Return True")
    public void shouldReturnTrue() {
        parser = new Parser("2");
        assertThat(true, is(parser.iterator().hasNext()));
    }

    @Test
    @DisplayName("should Return False")
    public void shouldReturnFalse() {
        parser = new Parser("");
        assertThat(false, is(parser.iterator().hasNext()));
    }

    @Test
    @DisplayName("should return token")
    public void shouldReturnNotNull() {
        parser = new Parser("+");
        assertThat(Operation.PLUS, is(parser.iterator().next().get().getOperation()));
    }
}
