(ns clj-jgit.util.print)

(defmacro when-present
  "Special `when` macro for checking if an attribute isn't available or is an empty string"
  [obj & body]
  `(when (not (or (nil? ~obj) (empty? ~obj)))
     ~@body))

(defmethod print-method org.eclipse.jgit.storage.file.RefDirectory$LooseUnpeeled
  [o w]
  (print-simple
   (str "#<" (.replaceFirst (str (.getClass o)) "class " "") ", "
        "Name: " (.getName o) ", "
        "ObjectId: " (.getName (.getObjectId o)) ">") w))