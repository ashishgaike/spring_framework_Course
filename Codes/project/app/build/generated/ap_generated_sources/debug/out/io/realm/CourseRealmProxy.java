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
public class CourseRealmProxy extends com.fitzafful.gliveportal.db.Course
    implements RealmObjectProxy, CourseRealmProxyInterface {

    static final class CourseColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long credit_hoursIndex;
        long lecturerIndex;
        long coreIndex;
        long registeredIndex;

        CourseColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Course");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.credit_hoursIndex = addColumnDetails("credit_hours", objectSchemaInfo);
            this.lecturerIndex = addColumnDetails("lecturer", objectSchemaInfo);
            this.coreIndex = addColumnDetails("core", objectSchemaInfo);
            this.registeredIndex = addColumnDetails("registered", objectSchemaInfo);
        }

        CourseColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CourseColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CourseColumnInfo src = (CourseColumnInfo) rawSrc;
            final CourseColumnInfo dst = (CourseColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.credit_hoursIndex = src.credit_hoursIndex;
            dst.lecturerIndex = src.lecturerIndex;
            dst.coreIndex = src.coreIndex;
            dst.registeredIndex = src.registeredIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("credit_hours");
        fieldNames.add("lecturer");
        fieldNames.add("core");
        fieldNames.add("registered");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private CourseColumnInfo columnInfo;
    private ProxyState<com.fitzafful.gliveportal.db.Course> proxyState;

    CourseRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CourseColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.fitzafful.gliveportal.db.Course>(this);
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
    public int realmGet$credit_hours() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.credit_hoursIndex);
    }

    @Override
    public void realmSet$credit_hours(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.credit_hoursIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.credit_hoursIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lecturer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lecturerIndex);
    }

    @Override
    public void realmSet$lecturer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lecturerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.lecturerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lecturerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lecturerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$core() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.coreIndex);
    }

    @Override
    public void realmSet$core(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.coreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.coreIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$registered() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.registeredIndex);
    }

    @Override
    public void realmSet$registered(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.registeredIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.registeredIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Course", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("credit_hours", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("lecturer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("core", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("registered", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CourseColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CourseColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Course";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.fitzafful.gliveportal.db.Course createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.fitzafful.gliveportal.db.Course obj = null;
        if (update) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Course.class);
            CourseColumnInfo columnInfo = (CourseColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CourseRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CourseRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Course.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CourseRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Course.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final CourseRealmProxyInterface objProxy = (CourseRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("credit_hours")) {
            if (json.isNull("credit_hours")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'credit_hours' to null.");
            } else {
                objProxy.realmSet$credit_hours((int) json.getInt("credit_hours"));
            }
        }
        if (json.has("lecturer")) {
            if (json.isNull("lecturer")) {
                objProxy.realmSet$lecturer(null);
            } else {
                objProxy.realmSet$lecturer((String) json.getString("lecturer"));
            }
        }
        if (json.has("core")) {
            if (json.isNull("core")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'core' to null.");
            } else {
                objProxy.realmSet$core((boolean) json.getBoolean("core"));
            }
        }
        if (json.has("registered")) {
            if (json.isNull("registered")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'registered' to null.");
            } else {
                objProxy.realmSet$registered((boolean) json.getBoolean("registered"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.fitzafful.gliveportal.db.Course createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.fitzafful.gliveportal.db.Course obj = new com.fitzafful.gliveportal.db.Course();
        final CourseRealmProxyInterface objProxy = (CourseRealmProxyInterface) obj;
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
            } else if (name.equals("credit_hours")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$credit_hours((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'credit_hours' to null.");
                }
            } else if (name.equals("lecturer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lecturer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lecturer(null);
                }
            } else if (name.equals("core")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$core((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'core' to null.");
                }
            } else if (name.equals("registered")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$registered((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'registered' to null.");
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

    public static com.fitzafful.gliveportal.db.Course copyOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Course object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.fitzafful.gliveportal.db.Course) cachedRealmObject;
        }

        com.fitzafful.gliveportal.db.Course realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Course.class);
            CourseColumnInfo columnInfo = (CourseColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((CourseRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.CourseRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.fitzafful.gliveportal.db.Course copy(Realm realm, com.fitzafful.gliveportal.db.Course newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Course) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.fitzafful.gliveportal.db.Course realmObject = realm.createObjectInternal(com.fitzafful.gliveportal.db.Course.class, ((CourseRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        CourseRealmProxyInterface realmObjectSource = (CourseRealmProxyInterface) newObject;
        CourseRealmProxyInterface realmObjectCopy = (CourseRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$credit_hours(realmObjectSource.realmGet$credit_hours());
        realmObjectCopy.realmSet$lecturer(realmObjectSource.realmGet$lecturer());
        realmObjectCopy.realmSet$core(realmObjectSource.realmGet$core());
        realmObjectCopy.realmSet$registered(realmObjectSource.realmGet$registered());
        return realmObject;
    }

    public static long insert(Realm realm, com.fitzafful.gliveportal.db.Course object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Course.class);
        long tableNativePtr = table.getNativePtr();
        CourseColumnInfo columnInfo = (CourseColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((CourseRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((CourseRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.credit_hoursIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$credit_hours(), false);
        String realmGet$lecturer = ((CourseRealmProxyInterface) object).realmGet$lecturer();
        if (realmGet$lecturer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lecturerIndex, rowIndex, realmGet$lecturer, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.coreIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$core(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.registeredIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$registered(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Course.class);
        long tableNativePtr = table.getNativePtr();
        CourseColumnInfo columnInfo = (CourseColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Course object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Course) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((CourseRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((CourseRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.credit_hoursIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$credit_hours(), false);
            String realmGet$lecturer = ((CourseRealmProxyInterface) object).realmGet$lecturer();
            if (realmGet$lecturer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lecturerIndex, rowIndex, realmGet$lecturer, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.coreIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$core(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.registeredIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$registered(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Course object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Course.class);
        long tableNativePtr = table.getNativePtr();
        CourseColumnInfo columnInfo = (CourseColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((CourseRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((CourseRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.credit_hoursIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$credit_hours(), false);
        String realmGet$lecturer = ((CourseRealmProxyInterface) object).realmGet$lecturer();
        if (realmGet$lecturer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lecturerIndex, rowIndex, realmGet$lecturer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lecturerIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.coreIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$core(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.registeredIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$registered(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Course.class);
        long tableNativePtr = table.getNativePtr();
        CourseColumnInfo columnInfo = (CourseColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Course.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Course object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Course) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((CourseRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((CourseRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.credit_hoursIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$credit_hours(), false);
            String realmGet$lecturer = ((CourseRealmProxyInterface) object).realmGet$lecturer();
            if (realmGet$lecturer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lecturerIndex, rowIndex, realmGet$lecturer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lecturerIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.coreIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$core(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.registeredIndex, rowIndex, ((CourseRealmProxyInterface) object).realmGet$registered(), false);
        }
    }

    public static com.fitzafful.gliveportal.db.Course createDetachedCopy(com.fitzafful.gliveportal.db.Course realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.fitzafful.gliveportal.db.Course unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.fitzafful.gliveportal.db.Course();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.fitzafful.gliveportal.db.Course) cachedObject.object;
            }
            unmanagedObject = (com.fitzafful.gliveportal.db.Course) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        CourseRealmProxyInterface unmanagedCopy = (CourseRealmProxyInterface) unmanagedObject;
        CourseRealmProxyInterface realmSource = (CourseRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$credit_hours(realmSource.realmGet$credit_hours());
        unmanagedCopy.realmSet$lecturer(realmSource.realmGet$lecturer());
        unmanagedCopy.realmSet$core(realmSource.realmGet$core());
        unmanagedCopy.realmSet$registered(realmSource.realmGet$registered());

        return unmanagedObject;
    }

    static com.fitzafful.gliveportal.db.Course update(Realm realm, com.fitzafful.gliveportal.db.Course realmObject, com.fitzafful.gliveportal.db.Course newObject, Map<RealmModel, RealmObjectProxy> cache) {
        CourseRealmProxyInterface realmObjectTarget = (CourseRealmProxyInterface) realmObject;
        CourseRealmProxyInterface realmObjectSource = (CourseRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$credit_hours(realmObjectSource.realmGet$credit_hours());
        realmObjectTarget.realmSet$lecturer(realmObjectSource.realmGet$lecturer());
        realmObjectTarget.realmSet$core(realmObjectSource.realmGet$core());
        realmObjectTarget.realmSet$registered(realmObjectSource.realmGet$registered());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Course = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{credit_hours:");
        stringBuilder.append(realmGet$credit_hours());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lecturer:");
        stringBuilder.append(realmGet$lecturer() != null ? realmGet$lecturer() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{core:");
        stringBuilder.append(realmGet$core());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{registered:");
        stringBuilder.append(realmGet$registered());
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
        CourseRealmProxy aCourse = (CourseRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCourse.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCourse.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCourse.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
