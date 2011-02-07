package scalariform.lexer

import java.io.BufferedReader
import java.io.FileReader

object Tokens {

  val PACKAGE = TokenType("PACKAGE")
  val STAR = TokenType("STAR")
  val WHILE = TokenType("WHILE")
  val CASE = TokenType("CASE")
  val NEW = TokenType("NEW")
  val DO = TokenType("DO")
  val EQUALS = TokenType("EQUALS")
  val SUBTYPE = TokenType("SUBTYPE")
  val EOF = TokenType("EOF")
  val SEALED = TokenType("SEALED")
  val TYPE = TokenType("TYPE")
  val LBRACKET = TokenType("LBRACKET")
  val FINAL = TokenType("FINAL")
  val RPAREN = TokenType("RPAREN")
  val IMPORT = TokenType("IMPORT")
  val STRING_LITERAL = TokenType("STRING_LITERAL")
  val FLOATING_POINT_LITERAL = TokenType("FLOATING_POINT_LITERAL")
  val EXCLAMATION = TokenType("EXCLAMATION")
  val NEWLINES = TokenType("NEWLINES")
  val THIS = TokenType("THIS")
  val RETURN = TokenType("RETURN")
  val VAL = TokenType("VAL")
  val VAR = TokenType("VAR")
  val SUPER = TokenType("SUPER")
  val RBRACE = TokenType("RBRACE")
  val LINE_COMMENT = TokenType("LINE_COMMENT")
  val PRIVATE = TokenType("PRIVATE")
  val NULL = TokenType("NULL")
  val ELSE = TokenType("ELSE")
  val CHARACTER_LITERAL = TokenType("CHARACTER_LITERAL")
  val MATCH = TokenType("MATCH")
  val TRY = TokenType("TRY")
  val WS = TokenType("WS")
  val SUPERTYPE = TokenType("SUPERTYPE")
  val INTEGER_LITERAL = TokenType("INTEGER_LITERAL")
  val OP = TokenType("OP")
  val USCORE = TokenType("USCORE")
  val LOWER = TokenType("LOWER")
  val CATCH = TokenType("CATCH")
  val FALSE = TokenType("FALSE")
  val VARID = TokenType("VARID")
  val THROW = TokenType("THROW")
  val UPPER = TokenType("UPPER")
  val PROTECTED = TokenType("PROTECTED")
  val CLASS = TokenType("CLASS")
  val DEF = TokenType("DEF")
  val LBRACE = TokenType("LBRACE")
  val FOR = TokenType("FOR")
  val LARROW = TokenType("LARROW")
  val ABSTRACT = TokenType("ABSTRACT")
  val LPAREN = TokenType("LPAREN")
  val IF = TokenType("IF")
  val AT = TokenType("AT")
  val MULTILINE_COMMENT = TokenType("MULTILINE_COMMENT")
  val SYMBOL_LITERAL = TokenType("SYMBOL_LITERAL")
  val OBJECT = TokenType("OBJECT")
  val COMMA = TokenType("COMMA")
  val YIELD = TokenType("YIELD")
  val TILDE = TokenType("TILDE")
  val PLUS = TokenType("PLUS")
  val PIPE = TokenType("PIPE")
  val VIEWBOUND = TokenType("VIEWBOUND")
  val RBRACKET = TokenType("RBRACKET")
  val DOT = TokenType("DOT")
  val WITH = TokenType("WITH")
  val IMPLICIT = TokenType("IMPLICIT")
  val LAZY = TokenType("LAZY")
  val TRAIT = TokenType("TRAIT")
  val HASH = TokenType("HASH")
  val FORSOME = TokenType("FORSOME")
  val MINUS = TokenType("MINUS")
  val TRUE = TokenType("TRUE")
  val SEMI = TokenType("SEMI")
  val COLON = TokenType("COLON")
  val OTHERID = TokenType("OTHERID")
  val REQUIRES = TokenType("REQUIRES")
  val NEWLINE = TokenType("NEWLINE")
  val FINALLY = TokenType("FINALLY")
  val OVERRIDE = TokenType("OVERRIDE")
  val ARROW = TokenType("ARROW")
  val EXTENDS = TokenType("EXTENDS")
  val XML_START_OPEN = TokenType("XML_START_OPEN", isXml = true)
  val XML_EMPTY_CLOSE = TokenType("XML_EMPTY_CLOSE", isXml = true)
  val XML_TAG_CLOSE = TokenType("XML_TAG_CLOSE", isXml = true)
  val XML_END_OPEN = TokenType("XML_END_OPEN", isXml = true)
  val XML_WHITESPACE = TokenType("XML_WHITESPACE", isXml = true)
  val XML_ATTR_EQ = TokenType("XML_ATTR_EQ", isXml = true)
  val XML_ATTR_VALUE = TokenType("XML_ATTR_VALUE", isXml = true)
  val XML_NAME = TokenType("XML_NAME", isXml = true)
  val XML_PCDATA = TokenType("XML_PCDATA", isXml = true)
  val XML_COMMENT = TokenType("XML_COMMENT", isXml = true)
  val XML_CDATA = TokenType("XML_CDATA", isXml = true)
  val XML_UNPARSED = TokenType("XML_UNPARSED", isXml = true)
  val XML_PROCESSING_INSTRUCTION = TokenType("XML_PROCESSING_INSTRUCTION", isXml = true)

  val KEYWORDS = Set(
    ABSTRACT, CASE, CATCH, CLASS, DEF,
    DO, ELSE, EXTENDS, FINAL,
    FINALLY, FOR, FORSOME, IF, IMPLICIT,
    IMPORT, LAZY, MATCH, NEW,
    OBJECT, OVERRIDE, PACKAGE, PRIVATE, PROTECTED,
    REQUIRES, RETURN, SEALED, SUPER, THIS,
    THROW, TRAIT, TRY, TYPE,
    VAL, VAR, WHILE, WITH, YIELD)

  val COMMENTS = Set(LINE_COMMENT, MULTILINE_COMMENT, XML_COMMENT)

  val IDS = Set(VARID, OTHERID, PLUS, MINUS, STAR, PIPE, TILDE, EXCLAMATION)

  val LITERALS = Set(CHARACTER_LITERAL, INTEGER_LITERAL, FLOATING_POINT_LITERAL, STRING_LITERAL, SYMBOL_LITERAL, TRUE, FALSE, NULL)

}

case class TokenType(name: String, isXml: Boolean = false) {
  override lazy val toString = name

  def isNewline = this == Tokens.NEWLINE || this == Tokens.NEWLINES

  def isKeyword = Tokens.KEYWORDS contains this

  def isComment = Tokens.COMMENTS contains this

  def isId = Tokens.IDS contains this

  def isLiteral = Tokens.LITERALS contains this
}
