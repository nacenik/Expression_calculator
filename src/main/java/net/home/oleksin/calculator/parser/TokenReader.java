package net.home.oleksin.calculator.parser;


interface TokenReader {

    Token proceed(ParserContext parserContext);
}
