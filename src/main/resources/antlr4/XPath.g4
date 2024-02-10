grammar XPath;

@header {
    package org.example.parsers;
}

// Parser rules
ap: docName slash rp;

rp: tagName             #Tag
   | STAR               #All
   | CURRENT            #Current
   | PARENT             #Parent
   | TEXT               #Text
   | attrName           #Attribute
   | LPR rp RPR         #ParenthesizedRp
   | rp slash rp        #SlashRp
   | rp LSB f RSB       #FilterRp
   | rp COMMA rp        #CommaRp;

f: rp                   #RpFilter
   | rp comp rp         #CompareFilter
   | rp EQ_N stringConstant #ConstantFilter
   | LPR f RPR          #ParenthesizedFilter
   | f logic f          #LogicFilter
   | NOT f              #NotFilter;

// Helper rules for structure
slash: SSLASH | DSLASH;
docName: doc LPR STRING RPR;

// Elements and attributes
tagName: ID;
attrName: AT ID;

// Comparison and logical operators
comp: EQ | EQ_N | IS | IS_N;
logic: AND | OR;

// Constants
stringConstant: STRING;

// Keywords
doc: 'doc' | 'document';

// Tokens (unchanged as per request)
LPR: '(';
RPR: ')';
LSB: '[';
RSB: ']';

SSLASH: '/';
DSLASH: '//';
CURRENT: '.';
PARENT: '..';

STAR: '*';
COMMA: ',';

NOT: 'not';
AND: 'and';
OR: 'or';

EQ_N: '=';
EQ: 'eq';
IS_N: '==';
IS: 'is';

TEXT: 'text()';
AT: '@';

ID: [a-zA-Z0-9_-]+;
WS: [ \t\n\r]+ -> skip;

STRING: '"' ( ESCAPE | ~["\\] )* '"' | '\'' ( ESCAPE | ~['\\] )* '\'';

ESCAPE: '\\' ( ['"\\] );
