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
public class GradeRealmProxy extends com.fitzafful.gliveportal.db.Grade
    implements RealmObjectProxy, GradeRealmProxyInterface {

    static final class GradeColumnInfo extends ColumnInfo {
        long idIndex;
        long subjectIndex;
        long class_scoreIndex;
        long exam_scoreIndex;
        long total_scoreIndex;
        long gradeIndex;
        long termIndex;
        long yearIndex;

        GradeColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Grade");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.subjectIndex = addColumnDetails("subject", objectSchemaInfo);
            this.class_scoreIndex = addColumnDetails("class_score", objectSchemaInfo);
            this.exam_scoreIndex = addColumnDetails("exam_score", objectSchemaInfo);
            this.total_scoreIndex = addColumnDetails("total_score", objectSchemaInfo);
            this.gradeIndex = addColumnDetails("grade", objectSchemaInfo);
            this.termIndex = addColumnDetails("term", objectSchemaInfo);
            this.yearIndex = addColumnDetails("year", objectSchemaInfo);
        }

        GradeColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GradeColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GradeColumnInfo src = (GradeColumnInfo) rawSrc;
            final GradeColumnInfo dst = (GradeColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.subjectIndex = src.subjectIndex;
            dst.class_scoreIndex = src.class_scoreIndex;
            dst.exam_scoreIndex = src.exam_scoreIndex;
            dst.total_scoreIndex = src.total_scoreIndex;
            dst.gradeIndex = src.gradeIndex;
            dst.termIndex = src.termIndex;
            dst.yearIndex = src.yearIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(8);
        fieldNames.add("id");
        fieldNames.add("subject");
        fieldNames.add("class_score");
        fieldNames.add("exam_score");
        fieldNames.add("total_score");
        fieldNames.add("grade");
        fieldNames.add("term");
        fieldNames.add("year");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private GradeColumnInfo columnInfo;
    private ProxyState<com.fitzafful.gliveportal.db.Grade> proxyState;

    GradeRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GradeColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.fitzafful.gliveportal.db.Grade>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$subject() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.subjectIndex);
    }

    @Override
    public void realmSet$subject(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.subjectIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.subjectIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.subjectIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.subjectIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$class_score() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.class_scoreIndex);
    }

    @Override
    public void realmSet$class_score(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.class_scoreIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.class_scoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.class_scoreIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.class_scoreIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$exam_score() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.exam_scoreIndex);
    }

    @Override
    public void realmSet$exam_score(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.exam_scoreIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.exam_scoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.exam_scoreIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.exam_scoreIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$total_score() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.total_scoreIndex);
    }

    @Override
    public void realmSet$total_score(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.total_scoreIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.total_scoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.total_scoreIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.total_scoreIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$grade() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.gradeIndex);
    }

    @Override
    public void realmSet$grade(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.gradeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.gradeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.gradeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.gradeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$term() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.termIndex);
    }

    @Override
    public void realmSet$term(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.termIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.termIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.termIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.termIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$year() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.yearIndex);
    }

    @Override
    public void realmSet$year(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.yearIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.yearIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.yearIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.yearIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Grade", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("subject", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("class_score", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("exam_score", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("total_score", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("grade", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("term", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("year", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GradeColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GradeColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Grade";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.fitzafful.gliveportal.db.Grade createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.fitzafful.gliveportal.db.Grade obj = null;
        if (update) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Grade.class);
            GradeColumnInfo columnInfo = (GradeColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GradeRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.GradeRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Grade.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GradeRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Grade.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final GradeRealmProxyInterface objProxy = (GradeRealmProxyInterface) obj;
        if (json.has("subject")) {
            if (json.isNull("subject")) {
                objProxy.realmSet$subject(null);
            } else {
                objProxy.realmSet$subject((String) json.getString("subject"));
            }
        }
        if (json.has("class_score")) {
            if (json.isNull("class_score")) {
                objProxy.realmSet$class_score(null);
            } else {
                objProxy.realmSet$class_score((String) json.getString("class_score"));
            }
        }
        if (json.has("exam_score")) {
            if (json.isNull("exam_score")) {
                objProxy.realmSet$exam_score(null);
            } else {
                objProxy.realmSet$exam_score((String) json.getString("exam_score"));
            }
        }
        if (json.has("total_score")) {
            if (json.isNull("total_score")) {
                objProxy.realmSet$total_score(null);
            } else {
                objProxy.realmSet$total_score((String) json.getString("total_score"));
            }
        }
        if (json.has("grade")) {
            if (json.isNull("grade")) {
                objProxy.realmSet$grade(null);
            } else {
                objProxy.realmSet$grade((String) json.getString("grade"));
            }
        }
        if (json.has("term")) {
            if (json.isNull("term")) {
                objProxy.realmSet$term(null);
            } else {
                objProxy.realmSet$term((String) json.getString("term"));
            }
        }
        if (json.has("year")) {
            if (json.isNull("year")) {
                objProxy.realmSet$year(null);
            } else {
                objProxy.realmSet$year((String) json.getString("year"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.fitzafful.gliveportal.db.Grade createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.fitzafful.gliveportal.db.Grade obj = new com.fitzafful.gliveportal.db.Grade();
        final GradeRealmProxyInterface objProxy = (GradeRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("subject")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$subject((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$subject(null);
                }
            } else if (name.equals("class_score")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$class_score((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$class_score(null);
                }
            } else if (name.equals("exam_score")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$exam_score((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$exam_score(null);
                }
            } else if (name.equals("total_score")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$total_score((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$total_score(null);
                }
            } else if (name.equals("grade")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$grade((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$grade(null);
                }
            } else if (name.equals("term")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$term((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$term(null);
                }
            } else if (name.equals("year")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$year((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$year(null);
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

    public static com.fitzafful.gliveportal.db.Grade copyOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Grade object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.fitzafful.gliveportal.db.Grade) cachedRealmObject;
        }

        com.fitzafful.gliveportal.db.Grade realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Grade.class);
            GradeColumnInfo columnInfo = (GradeColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class);
            long pkColumnIndex = columnInfo.idIndex;
            Number value = ((GradeRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.GradeRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.fitzafful.gliveportal.db.Grade copy(Realm realm, com.fitzafful.gliveportal.db.Grade newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Grade) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.fitzafful.gliveportal.db.Grade realmObject = realm.createObjectInternal(com.fitzafful.gliveportal.db.Grade.class, ((GradeRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        GradeRealmProxyInterface realmObjectSource = (GradeRealmProxyInterface) newObject;
        GradeRealmProxyInterface realmObjectCopy = (GradeRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$subject(realmObjectSource.realmGet$subject());
        realmObjectCopy.realmSet$class_score(realmObjectSource.realmGet$class_score());
        realmObjectCopy.realmSet$exam_score(realmObjectSource.realmGet$exam_score());
        realmObjectCopy.realmSet$total_score(realmObjectSource.realmGet$total_score());
        realmObjectCopy.realmSet$grade(realmObjectSource.realmGet$grade());
        realmObjectCopy.realmSet$term(realmObjectSource.realmGet$term());
        realmObjectCopy.realmSet$year(realmObjectSource.realmGet$year());
        return realmObject;
    }

    public static long insert(Realm realm, com.fitzafful.gliveportal.db.Grade object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Grade.class);
        long tableNativePtr = table.getNativePtr();
        GradeColumnInfo columnInfo = (GradeColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class);
        long pkColumnIndex = columnInfo.idIndex;
        Object primaryKeyValue = ((GradeRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$subject = ((GradeRealmProxyInterface) object).realmGet$subject();
        if (realmGet$subject != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
        }
        String realmGet$class_score = ((GradeRealmProxyInterface) object).realmGet$class_score();
        if (realmGet$class_score != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.class_scoreIndex, rowIndex, realmGet$class_score, false);
        }
        String realmGet$exam_score = ((GradeRealmProxyInterface) object).realmGet$exam_score();
        if (realmGet$exam_score != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.exam_scoreIndex, rowIndex, realmGet$exam_score, false);
        }
        String realmGet$total_score = ((GradeRealmProxyInterface) object).realmGet$total_score();
        if (realmGet$total_score != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.total_scoreIndex, rowIndex, realmGet$total_score, false);
        }
        String realmGet$grade = ((GradeRealmProxyInterface) object).realmGet$grade();
        if (realmGet$grade != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.gradeIndex, rowIndex, realmGet$grade, false);
        }
        String realmGet$term = ((GradeRealmProxyInterface) object).realmGet$term();
        if (realmGet$term != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
        }
        String realmGet$year = ((GradeRealmProxyInterface) object).realmGet$year();
        if (realmGet$year != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Grade.class);
        long tableNativePtr = table.getNativePtr();
        GradeColumnInfo columnInfo = (GradeColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Grade object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Grade) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            Object primaryKeyValue = ((GradeRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$subject = ((GradeRealmProxyInterface) object).realmGet$subject();
            if (realmGet$subject != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
            }
            String realmGet$class_score = ((GradeRealmProxyInterface) object).realmGet$class_score();
            if (realmGet$class_score != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.class_scoreIndex, rowIndex, realmGet$class_score, false);
            }
            String realmGet$exam_score = ((GradeRealmProxyInterface) object).realmGet$exam_score();
            if (realmGet$exam_score != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.exam_scoreIndex, rowIndex, realmGet$exam_score, false);
            }
            String realmGet$total_score = ((GradeRealmProxyInterface) object).realmGet$total_score();
            if (realmGet$total_score != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.total_scoreIndex, rowIndex, realmGet$total_score, false);
            }
            String realmGet$grade = ((GradeRealmProxyInterface) object).realmGet$grade();
            if (realmGet$grade != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.gradeIndex, rowIndex, realmGet$grade, false);
            }
            String realmGet$term = ((GradeRealmProxyInterface) object).realmGet$term();
            if (realmGet$term != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
            }
            String realmGet$year = ((GradeRealmProxyInterface) object).realmGet$year();
            if (realmGet$year != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Grade object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Grade.class);
        long tableNativePtr = table.getNativePtr();
        GradeColumnInfo columnInfo = (GradeColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class);
        long pkColumnIndex = columnInfo.idIndex;
        Object primaryKeyValue = ((GradeRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$subject = ((GradeRealmProxyInterface) object).realmGet$subject();
        if (realmGet$subject != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.subjectIndex, rowIndex, false);
        }
        String realmGet$class_score = ((GradeRealmProxyInterface) object).realmGet$class_score();
        if (realmGet$class_score != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.class_scoreIndex, rowIndex, realmGet$class_score, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.class_scoreIndex, rowIndex, false);
        }
        String realmGet$exam_score = ((GradeRealmProxyInterface) object).realmGet$exam_score();
        if (realmGet$exam_score != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.exam_scoreIndex, rowIndex, realmGet$exam_score, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.exam_scoreIndex, rowIndex, false);
        }
        String realmGet$total_score = ((GradeRealmProxyInterface) object).realmGet$total_score();
        if (realmGet$total_score != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.total_scoreIndex, rowIndex, realmGet$total_score, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.total_scoreIndex, rowIndex, false);
        }
        String realmGet$grade = ((GradeRealmProxyInterface) object).realmGet$grade();
        if (realmGet$grade != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.gradeIndex, rowIndex, realmGet$grade, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.gradeIndex, rowIndex, false);
        }
        String realmGet$term = ((GradeRealmProxyInterface) object).realmGet$term();
        if (realmGet$term != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.termIndex, rowIndex, false);
        }
        String realmGet$year = ((GradeRealmProxyInterface) object).realmGet$year();
        if (realmGet$year != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.yearIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Grade.class);
        long tableNativePtr = table.getNativePtr();
        GradeColumnInfo columnInfo = (GradeColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Grade.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Grade object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Grade) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            Object primaryKeyValue = ((GradeRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GradeRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$subject = ((GradeRealmProxyInterface) object).realmGet$subject();
            if (realmGet$subject != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.subjectIndex, rowIndex, false);
            }
            String realmGet$class_score = ((GradeRealmProxyInterface) object).realmGet$class_score();
            if (realmGet$class_score != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.class_scoreIndex, rowIndex, realmGet$class_score, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.class_scoreIndex, rowIndex, false);
            }
            String realmGet$exam_score = ((GradeRealmProxyInterface) object).realmGet$exam_score();
            if (realmGet$exam_score != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.exam_scoreIndex, rowIndex, realmGet$exam_score, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.exam_scoreIndex, rowIndex, false);
            }
            String realmGet$total_score = ((GradeRealmProxyInterface) object).realmGet$total_score();
            if (realmGet$total_score != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.total_scoreIndex, rowIndex, realmGet$total_score, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.total_scoreIndex, rowIndex, false);
            }
            String realmGet$grade = ((GradeRealmProxyInterface) object).realmGet$grade();
            if (realmGet$grade != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.gradeIndex, rowIndex, realmGet$grade, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.gradeIndex, rowIndex, false);
            }
            String realmGet$term = ((GradeRealmProxyInterface) object).realmGet$term();
            if (realmGet$term != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.termIndex, rowIndex, false);
            }
            String realmGet$year = ((GradeRealmProxyInterface) object).realmGet$year();
            if (realmGet$year != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.yearIndex, rowIndex, false);
            }
        }
    }

    public static com.fitzafful.gliveportal.db.Grade createDetachedCopy(com.fitzafful.gliveportal.db.Grade realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.fitzafful.gliveportal.db.Grade unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.fitzafful.gliveportal.db.Grade();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.fitzafful.gliveportal.db.Grade) cachedObject.object;
            }
            unmanagedObject = (com.fitzafful.gliveportal.db.Grade) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        GradeRealmProxyInterface unmanagedCopy = (GradeRealmProxyInterface) unmanagedObject;
        GradeRealmProxyInterface realmSource = (GradeRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$subject(realmSource.realmGet$subject());
        unmanagedCopy.realmSet$class_score(realmSource.realmGet$class_score());
        unmanagedCopy.realmSet$exam_score(realmSource.realmGet$exam_score());
        unmanagedCopy.realmSet$total_score(realmSource.realmGet$total_score());
        unmanagedCopy.realmSet$grade(realmSource.realmGet$grade());
        unmanagedCopy.realmSet$term(realmSource.realmGet$term());
        unmanagedCopy.realmSet$year(realmSource.realmGet$year());

        return unmanagedObject;
    }

    static com.fitzafful.gliveportal.db.Grade update(Realm realm, com.fitzafful.gliveportal.db.Grade realmObject, com.fitzafful.gliveportal.db.Grade newObject, Map<RealmModel, RealmObjectProxy> cache) {
        GradeRealmProxyInterface realmObjectTarget = (GradeRealmProxyInterface) realmObject;
        GradeRealmProxyInterface realmObjectSource = (GradeRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$subject(realmObjectSource.realmGet$subject());
        realmObjectTarget.realmSet$class_score(realmObjectSource.realmGet$class_score());
        realmObjectTarget.realmSet$exam_score(realmObjectSource.realmGet$exam_score());
        realmObjectTarget.realmSet$total_score(realmObjectSource.realmGet$total_score());
        realmObjectTarget.realmSet$grade(realmObjectSource.realmGet$grade());
        realmObjectTarget.realmSet$term(realmObjectSource.realmGet$term());
        realmObjectTarget.realmSet$year(realmObjectSource.realmGet$year());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Grade = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subject:");
        stringBuilder.append(realmGet$subject() != null ? realmGet$subject() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{class_score:");
        stringBuilder.append(realmGet$class_score() != null ? realmGet$class_score() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{exam_score:");
        stringBuilder.append(realmGet$exam_score() != null ? realmGet$exam_score() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total_score:");
        stringBuilder.append(realmGet$total_score() != null ? realmGet$total_score() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{grade:");
        stringBuilder.append(realmGet$grade() != null ? realmGet$grade() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{term:");
        stringBuilder.append(realmGet$term() != null ? realmGet$term() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{year:");
        stringBuilder.append(realmGet$year() != null ? realmGet$year() : "null");
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
        GradeRealmProxy aGrade = (GradeRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGrade.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGrade.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGrade.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
