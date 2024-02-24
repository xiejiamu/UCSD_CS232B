grammar XQuery;
import XPath;

// Main Rules
xq: VAR                           #VarXq
  | STRING                        #StringXq
  | ap                            #ApXq
  | LPR xq RPR                    #ParenthesizedXq
  | xq COMMA xq                   #BinaryXq
  | xq slash rp                  #RpXq
  | startTag LBB xq RBB endTag    #TagXq
  | forClause (letClause)? (whereClause)? returnClause #ForXq
  | letClause xq                  #LetXq
  | joinClause                    #JoinXq;

// Join Clauses
joinClause: JOIN LPR xq COMMA xq COMMA constantList COMMA constantList RPR #SimpleJoin
           | JOIN LPR joinClause COMMA xq COMMA constantList COMMA constantList RPR #NestedJoinLeft
           | JOIN LPR xq COMMA joinClause COMMA constantList COMMA constantList RPR #NestedJoinRight;

// List of Constants for Join
constantList: LSB ID (COMMA ID)* RSB;

// Clauses for For, Let, Where, and Return
forClause: FOR VAR IN xq (COMMA VAR IN xq)*; // Support multiple expressions
letClause: LET VAR ASSIGN xq (COMMA VAR ASSIGN xq)*;
whereClause: WHERE cond;
returnClause: RETURN xq;

// Condition expressions
cond: xq EQ xq     #EqCond1
    | xq EQ_N xq    #EqCond2
    | xq IS xq     #IsCond1
    | xq IS_N xq    #IsCond2
    | EMPTY LPR xq RPR #EmptyCond
    | satisfy cond #SatisfyCond
    | LPR cond RPR #ParenthesizedCond
    | cond logic cond #CompoundCond
    | NOT cond     #NegatedCond;

// Satisfy Clause
satisfy: SOME VAR IN xq (COMMA VAR IN xq)* SATISF;

// Tags and Brackets
startTag: LAB tagName RAB;
endTag: LAB SSLASH tagName RAB;

// Tokens
JOIN: [jJ][oO][iI][nN];
VAR: '$' ID;
LAB: '<';
RAB: '>';
LBB: '{';
RBB: '}';
FOR: 'for';
IN: 'in';
LET: 'let';
ASSIGN: ':=';
WHERE: 'where';
RETURN: 'return';
EMPTY: 'empty';
SOME: 'some';
SATISF: 'satisfies';
