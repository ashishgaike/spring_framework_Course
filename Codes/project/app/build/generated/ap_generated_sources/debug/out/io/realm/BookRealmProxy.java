package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class BookRealmProxy extends com.fitzafful.gliveportal.db.Book
    implements RealmObjectProxy, BookRealmProxyInterface {

    static final class BookColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long authorIndex;
        long reservedIndex;
        long me_reservedIndex;
        long genreIndex;
        long imgIndex;

        BookColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Book");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.authorIndex = addColumnDetails("author", objectSchemaInfo);
            this.reservedIndex = addColumnDetails("reserved", objectSchemaInfo);
            this.me_reservedIndex = addColumnDetails("me_reserved", objectSchemaInfo);
            this.genreIndex = addColumnDetails("genre", objectSchemaInfo);
            this.imgIndex = addColumnDetails("img", objectSchemaInfo);
        }

        BookColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BookColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BookColumnInfo src = (BookColumnInfo) rawSrc;
            final BookColumnInfo dst = (BookColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.authorIndex = src.authorIndex;
            dst.reservedIndex = src.reservedIndex;
            dst.me_reservedIndex = src.me_reservedIndex;
            dst.genreIndex = src.genreIndex;
            dst.imgIndex = src.imgIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(7);
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("author");
        fieldNames.add("reserved");
        fieldNames.add("me_reserved");
        fieldNames.add("genre");
        fieldNames.add("img");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private BookColumnInfo columnInfo;
    private ProxyState<com.fitzafful.gliveportal.db.Book> proxyState;

    BookRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BookColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.fitzafful.gliveportal.db.Book>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$author() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.authorIndex);
    }

    @Override
    public void realmSet$author(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.authorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.authorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.authorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.authorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$reserved() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.reservedIndex);
    }

    @Override
    public void realmSet$reserved(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.reservedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.reservedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$me_reserved() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.me_reservedIndex);
    }

    @Override
    public void realmSet$me_reserved(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.me_reservedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.me_reservedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$genre() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genreIndex);
    }

    @Override
    public void realmSet$genre(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genreIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genreIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genreIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$img() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imgIndex);
    }

    @Override
    public void realmSet$img(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imgIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Book", 7, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("author", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("reserved", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("me_reserved", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("genre", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("img", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BookColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BookColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Book";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.fitzafful.gliveportal.db.Book createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.fitzafful.gliveportal.db.Book obj = null;
        if (update) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Book.class);
            BookColumnInfo columnInfo = (BookColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BookRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.BookRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Book.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BookRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Book.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final BookRealmProxyInterface objProxy = (BookRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("author")) {
            if (json.isNull("author")) {
                objProxy.realmSet$author(null);
            } else {
                objProxy.realmSet$author((String) json.getString("author"));
            }
        }
        if (json.has("reserved")) {
            if (json.isNull("reserved")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'reserved' to null.");
            } else {
                objProxy.realmSet$reserved((boolean) json.getBoolean("reserved"));
            }
        }
        if (json.has("me_reserved")) {
            if (json.isNull("me_reserved")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'me_reserved' to null.");
            } else {
                objProxy.realmSet$me_reserved((boolean) json.getBoolean("me_reserved"));
            }
        }
        if (json.has("genre")) {
            if (json.isNull("genre")) {
                objProxy.realmSet$genre(null);
            } else {
                objProxy.realmSet$genre((String) json.getString("genre"));
            }
        }
        if (json.has("img")) {
            if (json.isNull("img")) {
                objProxy.realmSet$img(null);
            } else {
                objProxy.realmSet$img((String) json.getString("img"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.fitzafful.gliveportal.db.Book createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.fitzafful.gliveportal.db.Book obj = new com.fitzafful.gliveportal.db.Book();
        final BookRealmProxyInterface objProxy = (BookRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("author")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$author((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$author(null);
                }
            } else if (name.equals("reserved")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$reserved((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'reserved' to null.");
                }
            } else if (name.equals("me_reserved")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$me_reserved((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'me_reserved' to null.");
                }
            } else if (name.equals("genre")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$genre((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$genre(null);
                }
            } else if (name.equals("img")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$img((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$img(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.fitzafful.gliveportal.db.Book copyOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Book object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Book) cachedRealmObject;
        }

        com.fitzafful.gliveportal.db.Book realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Book.class);
            BookColumnInfo columnInfo = (BookColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((BookRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.BookRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.fitzafful.gliveportal.db.Book copy(Realm realm, com.fitzafful.gliveportal.db.Book newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Book) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.fitzafful.gliveportal.db.Book realmObject = realm.createObjectInternal(com.fitzafful.gliveportal.db.Book.class, ((BookRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        BookRealmProxyInterface realmObjectSource = (BookRealmProxyInterface) newObject;
        BookRealmProxyInterface realmObjectCopy = (BookRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$author(realmObjectSource.realmGet$author());
        realmObjectCopy.realmSet$reserved(realmObjectSource.realmGet$reserved());
        realmObjectCopy.realmSet$me_reserved(realmObjectSource.realmGet$me_reserved());
        realmObjectCopy.realmSet$genre(realmObjectSource.realmGet$genre());
        realmObjectCopy.realmSet$img(realmObjectSource.realmGet$img());
        return realmObject;
    }

    public static long insert(Realm realm, com.fitzafful.gliveportal.db.Book object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Book.class);
        long tableNativePtr = table.getNativePtr();
        BookColumnInfo columnInfo = (BookColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((BookRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((BookRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$author = ((BookRealmProxyInterface) object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$reserved(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.me_reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$me_reserved(), false);
        String realmGet$genre = ((BookRealmProxyInterface) object).realmGet$genre();
        if (realmGet$genre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreIndex, rowIndex, realmGet$genre, false);
        }
        String realmGet$img = ((BookRealmProxyInterface) object).realmGet$img();
        if (realmGet$img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Book.class);
        long tableNativePtr = table.getNativePtr();
        BookColumnInfo columnInfo = (BookColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Book object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Book) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((BookRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((BookRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$author = ((BookRealmProxyInterface) object).realmGet$author();
            if (realmGet$author != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$reserved(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.me_reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$me_reserved(), false);
            String realmGet$genre = ((BookRealmProxyInterface) object).realmGet$genre();
            if (realmGet$genre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genreIndex, rowIndex, realmGet$genre, false);
            }
            String realmGet$img = ((BookRealmProxyInterface) object).realmGet$img();
            if (realmGet$img != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Book object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Book.class);
        long tableNativePtr = table.getNativePtr();
        BookColumnInfo columnInfo = (BookColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((BookRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((BookRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$author = ((BookRealmProxyInterface) object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$reserved(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.me_reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$me_reserved(), false);
        String realmGet$genre = ((BookRealmProxyInterface) object).realmGet$genre();
        if (realmGet$genre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreIndex, rowIndex, realmGet$genre, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genreIndex, rowIndex, false);
        }
        String realmGet$img = ((BookRealmProxyInterface) object).realmGet$img();
        if (realmGet$img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imgIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Book.class);
        long tableNativePtr = table.getNativePtr();
        BookColumnInfo columnInfo = (BookColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Book.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Book object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Book) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((BookRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((BookRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$author = ((BookRealmProxyInterface) object).realmGet$author();
            if (realmGet$author != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$reserved(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.me_reservedIndex, rowIndex, ((BookRealmProxyInterface) object).realmGet$me_reserved(), false);
            String realmGet$genre = ((BookRealmProxyInterface) object).realmGet$genre();
            if (realmGet$genre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genreIndex, rowIndex, realmGet$genre, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.genreIndex, rowIndex, false);
            }
            String realmGet$img = ((BookRealmProxyInterface) object).realmGet$img();
            if (realmGet$img != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imgIndex, rowIndex, false);
            }
        }
    }

    public static com.fitzafful.gliveportal.db.Book createDetachedCopy(com.fitzafful.gliveportal.db.Book realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.fitzafful.gliveportal.db.Book unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.fitzafful.gliveportal.db.Book();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.fitzafful.gliveportal.db.Book) cachedObject.object;
            }
            unmanagedObject = (com.fitzafful.gliveportal.db.Book) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        BookRealmProxyInterface unmanagedCopy = (BookRealmProxyInterface) unmanagedObject;
        BookRealmProxyInterface realmSource = (BookRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$author(realmSource.realmGet$author());
        unmanagedCopy.realmSet$reserved(realmSource.realmGet$reserved());
        unmanagedCopy.realmSet$me_reserved(realmSource.realmGet$me_reserved());
        unmanagedCopy.realmSet$genre(realmSource.realmGet$genre());
        unmanagedCopy.realmSet$img(realmSource.realmGet$img());

        return unmanagedObject;
    }

    static com.fitzafful.gliveportal.db.Book update(Realm realm, com.fitzafful.gliveportal.db.Book realmObject, com.fitzafful.gliveportal.db.Book newObject, Map<RealmModel, RealmObjectProxy> cache) {
        BookRealmProxyInterface realmObjectTarget = (BookRealmProxyInterface) realmObject;
        BookRealmProxyInterface realmObjectSource = (BookRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$author(realmObjectSource.realmGet$author());
        realmObjectTarget.realmSet$reserved(realmObjectSource.realmGet$reserved());
        realmObjectTarget.realmSet$me_reserved(realmObjectSource.realmGet$me_reserved());
        realmObjectTarget.realmSet$genre(realmObjectSource.realmGet$genre());
        realmObjectTarget.realmSet$img(realmObjectSource.realmGet$img());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Book = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author() != null ? realmGet$author() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reserved:");
        stringBuilder.append(realmGet$reserved());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{me_reserved:");
        stringBuilder.append(realmGet$me_reserved());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{genre:");
        stringBuilder.append(realmGet$genre() != null ? realmGet$genre() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{img:");
        stringBuilder.append(realmGet$img() != null ? realmGet$img() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRealmProxy aBook = (BookRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBook.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBook.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBook.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
