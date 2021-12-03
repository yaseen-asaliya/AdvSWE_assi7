in part 2 the answer of last two Requirements in files 
or :

(par2-req3):
part 1:
Briefly, I expected errors to occur in the release and send functions,and I created
a special Exception in every error that could happen, and I made a handling for each
of these Exceptions, and then I used Try-Catch in the Demo Class to use each of the 
Exceptions that I made when There is a reason to summon it.

part 2:
I put each logger in a suitable place for it, for example, I put the Error Logger in
the catch because when this catch is called, there will be an error that has occurred,
the warning logger when a specific protocol is deleted to alert the user that there is
a deletion, the info logger when a comparison process is being searched for example,
and the debug logger when Define protocols.


(par2-req4):
why the logger uses a singleton design pattern ?

Logging is a fundamental part of applications Logs can inform us of many
 useful things such as; errors, warnings, stack traces, order of operations,
 events, etc ,with this information , we are able to find, and therefore resolve
 bugs more quickly, and ensure our applications are running correctly and logs
 can be stored to many storage devices, such as slack channels and server logs,
 making them more accessible to us.
